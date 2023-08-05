import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Love-OverFlow
 * @date 2023/8/2
 */
public class Example {
    public static void main(String[] args) {
        List<String> list= new ArrayList<>(); // 创建 aggregate 集合对象, 我更喜欢叫容器
        list.add("List 是支持迭代器遍历的容器");
        // 写法 1
        Iterator<String> iterator = list.listIterator(); // 创建迭代器对象
        // 使用迭代器遍历
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 写法 2, 完全等价
        // for-each loop 语法糖
        for (var s : list) {
            System.out.println(s);
        }
    }
}
