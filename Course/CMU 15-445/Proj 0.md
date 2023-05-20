![image-20230520154719453](https://cdn.jsdelivr.net/gh/Love-OverFlow/notesImage/img/202305201547529.png)



### C++ 语法学习

unique_ptr

- [【C++数据库内核】CMU15-445/645实验项目Project 0_bilibili](https://www.bilibili.com/video/BV16G4y1z7Xm/?spm_id_from=333.999.0.0&vd_source=d638f494de49bbb98ccb6eb1ce690b01)

左值与右值

- [【C/C++】- 左值和右值（part 1 - part 3)_bilibili](https://www.bilibili.com/video/BV17d4y127qZ/?spm_id_from=333.999.0.0&vd_source=d638f494de49bbb98ccb6eb1ce690b01)
- [详解const int* 与 int const*的区别-CSDN博客](https://blog.csdn.net/weiyuanzhang123/article/details/117592035)

转发引用（万能引用）和完美转发

- [【C/C++】转发引用、复制消除、亡值 -左值和右值（完）](https://www.bilibili.com/video/BV1MP4y1S76m/?spm_id_from=333.999.0.0&vd_source=d638f494de49bbb98ccb6eb1ce690b01&t=09m57s)
- [聊聊C++中的完美转发 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/161039484)

### 前缀树

![image-20230520153416381](https://cdn.jsdelivr.net/gh/Love-OverFlow/notesImage/img/202305201534455.png)

这个前缀树的结构和我之前学习的前缀树稍有不同，子节点的字符并不是通过路径来确定的，而是作为成员变量存储在 Node 节点中

------

------

**TrieNode**

```cpp
class TrieNode {
		char key_char_;
		bool is_end_{false};
		std::unordered_map<char, std::unique_ptr<TrieNode>> children_;
}
```

1. 第40行，补充TrieNode的构造方法

```cpp
explicit TrieNode(char key_char) : key_char_(key_char) {}
```

- 讲解
  - explicit为显式转换，简单来说是指不能使用直接赋值的方式让编译器自动类型转换。如`string s = 10` 不会自动转换成string类型。
  - 复习一下构造函数的初始化列表写法，[这种写法有时候会更快](https://blog.csdn.net/qq767852841/article/details/114157338)
  - 不能把`is_end_(false)`带上，并不会报错，但是不符合规范。

1. 第50行，补充TrieNode的移动构造函数

```cpp
TrieNode(TrieNode &&other_trie_node) noexcept
	: children_(std::move(other_trie_node.children_)) {
    key_char_ = other_trie_node.key_char_;
    is_end_ = other_trie_node.is_end_;
}
// 另一种写法
TrieNode(TrieNode &&other_trie_node) noexcept {
    key_char_ = other_trie_node.key_char_;
    is_end_ = other_trie_node.is_end_;
    children_.swap(other_trie_node.children_);
}
```

- 讲解

  - &&为右值引用

  - std::move()和std::forward()是移动所有权的方法，move()用于将左值对象转成右值对象，然后传给对应的移动构造函数，常用于避免有些只能存在一份的数据又多了一份，如本例的children_，而forward()是将参数连同类型转发给其他函数，保留原本的const、值属性。不用move()或forward()会直接报错。

  - children_变量因为包含unique指针，所以不能写在大括号{}中赋值，而只能使用初始化列表，直接调用移动构造函数

  - unique_ptr<>**是一个**独享指针，指该指针指向的资源只能由unique_ptr拥有，无法复制。这里利用该指针来节省资源并减少复制操作可能产生的错误。


1. 第65、75、84、93行`HasChild`、`HasChildren`、`IsEndNode`、`GetKeyChar`函数

```cpp
// 规范要求不要有隐式类型转换
bool HasChild(char key_char) const { 
	return children_.count(key_char) != 0; // 和m.find() != m.end()效率是一样的
	// 使用count的可读性更好，也更贴合思维逻辑
}
// 略
```

- 复习
  - 函数后加const表示该函数中无法获取this指针。简单来说就是这种修饰方式表示该函数中不能更改TrieNode类中的成员变量。

1. 第114行，插入孩子节点。

```cpp
std::unique_ptr<TrieNode> *InsertChildNode(char key_char, std::unique_ptr<TrieNode> &&child) {
    if (key_char != child->GetKeyChar()) {
      return nullptr;
    }
    if (HasChild(key_char)) {
      return nullptr;
    }
    children_[key_char] = std::move(child);
    return &children_[key_char];
  }
```

- 讲解
  - 函数参数虽然是右值引用，但是在进入函数体后，就变成左值了（已经可以寻址、做修改了嘛），所以转移 unique_ptr child 的时候需要再调用一次move

1. 第126行，获取孩子节点

```cpp
std::unique_ptr<TrieNode> *GetChildNode(char key_char) {
    auto itr = children_.find(key_char);
    if (itr != children_.end()) {
      return &itr->second; // 复习一下迭代器的用法
    }
    return nullptr;
  }
```

- 讲解
  - 返回c++中的NULL和nullptr是不同的，NULL其实就是0，当作为传入使用时，可能不会被视为指针而是一个变量。

------

**TrieNodeWithValue**

略

**Trie**

**Insert 插入函数**

```cpp
template <typename T>
  bool Insert(const std::string &key, T value) {
    if (key.empty()) {
      return false;
    }

    // unique_ptr 不能拷贝, 但是可以有指向它的指针( ptr 是指针的指针)
    std::unique_ptr<TrieNode> *pre = &root_;  // 暂存 key 的父节点
    std::unique_ptr<TrieNode> *ptr;           // 用于遍历 key
    int size = key.size();

    for (int i = 0; i < size; i++) {
      ptr = (*pre)->GetChildNode(key[i]);
      if (ptr == nullptr) {  // 如果没找到, 将尾部缺少的字符全部插入
        ptr = pre;           // 用 ptr 来遍历 key 并插入到树中
        while (i < size) {
          ptr = (*ptr)->InsertChildNode(key[i], std::make_unique<TrieNode>(key[i]));
          i++;
        }
        // 释放 ptr 指向的 TrieNode (末尾字符所在节点) , 换成 TrieNodeWithValue
        ptr->reset(new TrieNodeWithValue(std::move(**ptr), value));
        // 我们并没有改变原来指向 TrieNode 节点的裸指针, 我们是直接对管理这个裸指针的unique_ptr管理变量进行了修改
        // 所以不需要对 ptr 节点的父节点进行相应修改
        return true;
      }

      if (i == size - 1) {  // 如果遍历到了最后一个字符, 检查其是否已经保存在 Trie 树中
        if ((*ptr)->IsEndNode()) {
          return false;
        }
        // 树中有这个结点, 但是没有作为 key-value 存储, 而是一个纯中间节点, 现在修改它
        ptr->reset(new TrieNodeWithValue(std::move(**ptr), value));
        return true;
      }

      pre = ptr;  // 更新父节点
    }

    return false;  // 结尾返回, 防止编译器抱怨
  }
```

**Remove 删除函数**

这里要理解清楚了再写，而网页上的描述令人十分困惑。真实的题目意思是：删除过程中，我们应该移除那些不是别的节点的一部分的节点，若key不符合要求(如:为空，找的过程中出现nullptr)，直接return false。具体含义如下

- 首先要根据每一个字符，从root节点开始遍历，找到终端节点。在我们找到终端节点前，若出现nullptr的情况，则直接返回false，查找失败。
- 找到终端节点后，首先判断它是否有别的子节点，若有孩子，则设定它的Is_end_标记为false，说明该节点还有别的孩子，这一条路线是别的key的前缀，不能删除，return true。
- 找到终端节点后，若它没有别的孩子，那么此时我们可以进行递归删除了。

```cpp
bool Remove(const std::string &key) {
    if (key.empty()) {
      return false;
    }
    std::unique_ptr<TrieNode> *ptr = &root_;
    std::stack<std::unique_ptr<TrieNode> *> st;  // 用于递归删除该 key 所独占的支线上的节点
    st.emplace(ptr);
    for (size_t i = 0; i < key.size(); i++) {
      ptr = (*ptr)->GetChildNode(key[i]);
      if (ptr == nullptr) {
        return false;
      }
      st.emplace(ptr);

      if (i == key.size() - 1 && (*ptr)->IsEndNode()) {  // 树中确实存在该 key
        (*ptr)->SetEndNode(false);                       // 要删除节点的标志位为 false

        // 尝试递归向上回溯删除
        while (st.size() > 1) {  // 至多删除除了 root 之外的全部下游节点
          ptr = st.top();
          st.pop();

          if (!(*ptr)->HasChildren() && !(*ptr)->IsEndNode()) {  // 当前节点是否是其他分支的一员
            (*st.top())->RemoveChildNode(key[i]);
            i--;
          } else {  // 是其他分支的一员, 停止删除
            return true;
          }
        }
        if (st.size() == 1) {  // 剩下 root 节点
          return true;
        }
      }
    }

    return false;
  }
```

- 讲解
  - 插入容器使用emplace，这样不管编译时开几级优化、插入时调用的是 构造函数、移动构造还是拷贝构造，都能保证效率最高（[当然大多数情况下push的效率也一样高就是了](https://zhuanlan.zhihu.com/p/183861524?utm_source=wechat_session&utm_id=0)）

**GetValue 从树中取值函数**

```cpp
template <typename T>
  T GetValue(const std::string &key, bool *success) {
    *success = false;
    if (key.empty()) {
      return {};
    }
    std::unique_ptr<TrieNode> *ptr = &root_;
    for (size_t i = 0; i < key.size(); i++) {
      ptr = (*ptr)->GetChildNode(key[i]);
      if (ptr == nullptr) {
        return {};
      }
      if (i == key.size() - 1 && (*ptr)->IsEndNode()) {
        auto p_node_with_value = dynamic_cast<TrieNodeWithValue<T> *>(ptr->get());  // 相当于 &**ptr
        if (p_node_with_value != nullptr) {
          *success = true;
          return p_node_with_value->GetValue();
        }
      }
    }

    return {};
  }
```

- 讲解
  - dynamic_cast的使用在题干中有提示，用于判定返回类型T和查询到的返回类型是否一致，如果不一致，会返回nullptr。
    - • `dynamic_cast` 继承关系间互相转换，用于指针\引用

------

------

### 简单并发

Trie 树需要保证 insert、search、remove 操作在多线程环境中工作，参照课程网站的描述对临界资源加锁即可

### 项目参考资料

[CMU15-445 2022 project 0:C++primer总结 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/609483077)

[CMU15-445/645(Fall 2022) P0字典树V1 - 飞书云文档 (feishu.cn)](https://ym9omojhd5.feishu.cn/docs/doccnM3F37WfhkcFYREGLOk2zhe)

[CMU 15-445 Project #0 满分测试通过，代码讲解及注意事项 (qq.com)](https://mp.weixin.qq.com/s/TaIP-HAEY40E-kDiRnLxvA)

[CMU 15-445 Project #0 满分测试通过，代码讲解及注意事项 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/620524876)[个人的C++简单学习路线 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/596523130)

[CMU15-445 2022 project 0:C++primer总结 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/609483077)