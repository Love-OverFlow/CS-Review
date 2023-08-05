/**
 * @author Love-OverFlow
 * @date 2023/8/5
 */
public class Client {
    public static void main(String[] args) {
        // 声明对象数据结构
        ObjectStructure objectStructure = new ObjectStructure();
        // 创建可以存储在其中的一种元素
        Element element = new ConcreteElementA();
        // 添加进底层存储结构
        objectStructure.add(element);

        // 创建可以对该数据结构中的至少一种元素进行访问的访问者
        Visitor visitor = new ConcreteVisitor();
        // 使用该访问者进行遍历
        objectStructure.traversal(visitor);
    }
    /**
     * [OUT]
     * 对元素 A 的访问
     */
}
