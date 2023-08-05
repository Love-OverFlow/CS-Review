/**
 * @author Love-OverFlow
 * @date 2023/8/5
 */
public class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElementA elem) {
        System.out.println("对元素 A 的访问");
    }
    // 对其他元素的访问, ...
}
