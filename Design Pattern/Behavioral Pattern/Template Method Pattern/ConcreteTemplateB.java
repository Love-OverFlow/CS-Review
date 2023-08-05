/**
 * @author Love-OverFlow
 * @date 2023/7/28
 */

// 具体模板类 B
public class ConcreteTemplateB extends AbstractTemplate {
    @Override
    protected void abstractMethod() {
        System.out.println("B 子类中重写的抽象方法");
    }
}
