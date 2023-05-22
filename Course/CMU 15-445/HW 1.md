![image-20230522205506952](https://cdn.jsdelivr.net/gh/Love-OverFlow/notesImage/img/202305222055031.png)

### Q3

```sql
-- 计算迄今为止的年龄的话就写成如下形式
-- SELECT name, (strftime('%Y', date('now')) - born) AS age

SELECT name, (2022 - born) AS age
FROM people
WHERE died IS NULL
    AND born >= 1900
ORDER BY born, name
LIMIT 20;

-- 参考答案是这样写的：
-- 	CASE
-- 		WHEN died IS NOT NULL
-- 		THEN died - born
-- 		ELSE 2022 - born
-- 	END AS age
-- 也就是说，它求的是自 1900 年来最长寿的人(不管现在死活)
-- 我的答案是理解成现存的人中，年纪最大的
-- 不过恰好输出是一样的
```

### Q5 Decade Ratings

这里可以使用 SQLite 提供的一个特性：

📌 SQLite3: 支持在`GROUP BY`中使用`SELECT`定义的聚合字段

```sql
SELECT
	(premiered-premiered%10) || 's' AS decade,
	ROUND(AVG(rating), 2) AS avg_rating,
	MAX(rating) AS top_rating,
	MIN(rating) AS min_rating,
	COUNT(*) AS num_releases
FROM
	titles t, ratings r
WHERE
	premiered IS NOT NULL
	AND t.title_id = r.title_id
GROUP BY 
	decade
ORDER BY 
	avg_rating DESC, decade;
```

相当于数据在`premiered` 列上进行了聚合，这个聚合不是通过调用MAX()或SUM()等内置聚合函数实现的，而是我们自定义了一个聚合条件：将所有同一年代（10年内）的数据聚合成一组；然后在 `GROUP BY` 语句中调用该聚合函数的结果进行分组

那这个是不是和语句的执行逻辑相悖呢？如果是先执行 `GROUP BY` 再 `SELECT` 的话，不就会报错了吗，[实际上，这种执行顺序的理解是我们为了便于编写SQL程序而自己构造的，数据库不一定会如此分析代码，比如 SQLite3 就支持上述程序的运行](https://cloud.tencent.com/developer/ask/sof/213023)。

### Q7

复习一下刚学的 CTE

```sql
WITH sY(year) AS (
    SELECT premiered 
    FROM titles 
    WHERE primary_title = 'Army of Thieves'
)
SELECT COUNT(*)
FROM titles t, sY
WHERE premiered = sY.year;
```

### Q8

```sql
WITH nkWorks AS (
    SELECT DISTINCT title_id
    FROM crew c, people p
    WHERE c.person_id = p.person_id
        AND p.name = 'Nicole Kidman'
        AND p.born = 1967
)
SELECT DISTINCT name
FROM people p, crew c
WHERE p.person_id = c.person_id
    AND c.title_id IN nkWorks
    AND (c.category = 'actor' OR c.category = 'actress')
ORDER BY name;

-- 换成 AND c.category = ('actor' OR 'actress')
-- 就不行，这是因为 ('actor' OR 'actress') 的结果是 0
-- 这就变成了 c.category = 0 了
```

- 后半段查询也可以是

  ```sql
  SELECT DISTINCT name
  FROM people p, crew c, nkWorks
  WHERE p.person_id = c.person_id
      AND c.title_id = nkWorks.title_id
      AND (c.category = 'actor' OR c.category = 'actress')
  ORDER BY name;
  ```

### Q9

这个题目的描述是比较奇怪的，结合参考答案的输出，更是让人困惑，转译一下：

对于所有生于 1955 年的人，获取他们的名字和其参演的所有电影的平均分，并使用`NTILE(10)`分片函数，按平均分递增规则分片，最后输出并列第 9 顺位（T9队伍）的人的名字和其参演电影的平均分。输出时，按平均分降序和名称字典升序排列。

```sql
-- 对所有生于 1955 年的人，获取他们的名字和其参演的所有电影的平均分
WITH naRating AS (
    SELECT name, ROUND(AVG(rating), 2) AS avg_rating
    FROM people p, ratings r, crew c, titles t
    WHERE p.born = 1955
        AND t.type = 'movie'
        AND p.person_id = c.person_id
        AND c.title_id = r.title_id
        AND c.title_id = t.title_id
    GROUP BY p.person_id
),
-- 使用 NTILE(10) 分片函数，按平均分递增规则分片
outlist AS (
    SELECT *, NTILE(10) OVER (ORDER BY avg_rating) AS tile -- 窗口函数，会附加新列
    FROM naRating
)
-- 输出 T9 队伍的人的名字和其参演电影的平均分
SELECT name, avg_rating
FROM outlist
WHERE tile = 9
ORDER BY avg_rating DESC, name;
```

[MySQL 8.0 Reference Manual :: NTILE()](https://dev.mysql.com/doc/refman/8.0/en/window-function-descriptions.html#function_ntile) (MySQL 的文档，但用法是一样的，而且排版比[SQLite](https://www.sqlitetutorial.net/sqlite-window-functions/sqlite-ntile/)的清晰)

### Q10

本想使用group_concat(title, ‘, ’)来做连接，但是查询后发现：

|                     |                                                              |
| ------------------- | ------------------------------------------------------------ |
| group_concat(x[,y]) | 该函数返回一个字符串，该字符串将会连接所有非NULL的x值。该函数的y参数将作为每个x值之间的分隔符，如果在调用时忽略该参数，在连接时将使用缺省分隔符","。再有就是各个字符串之间的连接顺序是不确定的。 |

### 参考资料

[CMU 15-445 Homework 1 SQL - 掘金 (juejin.cn)](https://juejin.cn/post/7142152700501688356)

[SQL操作顺序-使用在SELECT中创建的字段进行分组 - 问答 - 腾讯云开发者社区-腾讯云 (tencent.com)](https://cloud.tencent.com/developer/ask/sof/213023)

[MySQL :: MySQL 8.0 Reference Manual :: 12.20.1 Window Function Descriptions](https://dev.mysql.com/doc/refman/8.0/en/window-function-descriptions.html#function_ntile)

[SQLite学习手册(内置函数) | SQLite 学习手册 (gitbooks.io)](https://wizardforcel.gitbooks.io/sqlite-learning-manual/content/5.html)
