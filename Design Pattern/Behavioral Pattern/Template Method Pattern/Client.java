/**
 * @author Love-OverFlow
 * @date 2023/7/28
 */
public class Client {
    public static void main(String[] args) {
        // 调用子类 A 的模板方法
        AbstractTemplate tpl = new ConcreteTemplateA();
        tpl.templateMethod();
        /**
         * [OUT]
         * A 子类中重写的抽象方法
         * 抽象类中的具体方法
         */

        // 调用子类 B 的模板方法
        tpl = new ConcreteTemplateB();
        tpl.templateMethod();
        /**
         * [OUT]
         * B 子类中重写的抽象方法
         * 抽象类中的具体方法
         */
    }
}
