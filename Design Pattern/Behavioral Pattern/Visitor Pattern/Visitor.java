/**
 * @author Love-OverFlow
 * @date 2023/8/5
 */

// 抽象的访问者角色, 需要针对每种被访问元素都定义一个 api
public interface Visitor {
    // 针对元素 A 的 api, 传入的参数也是元素 A
    void visit(ConcreteElementA elem);
    // 针对元素 B 的 api, ...
}
