/**
 * @author Love-OverFlow
 * @date 2023/7/28
 */

// 具体模板类 A
public class ConcreteTemplateA extends AbstractTemplate {
    @Override
    protected void abstractMethod() {
        System.out.println("A 子类中重写的抽象方法");
    }
}
