/**
 * @author Love-OverFlow
 * @date 2023/8/5
 */
public class ConcreteElementA implements Element {

    @Override
    public void accept(Visitor visitor) {
        // 在方法内部将自身（this）委托给访问者完成特定的操作
        visitor.visit(this);
    }
}
