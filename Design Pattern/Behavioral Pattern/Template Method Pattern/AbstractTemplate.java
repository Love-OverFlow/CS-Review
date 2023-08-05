/**
 * @author Love-OverFlow
 * @date 2023/7/28
 */

/**
 * 抽象模板, 提供大致的框架
 */
abstract class AbstractTemplate {
    // 模板方法
    public void templateMethod() {
        /**
         * 模板方法是把基本操作方法组合在一起形成一个总算法或一个总行为的方法。
         * 一个抽象类可以有任意多个模板方法, 一个模板方法可以调用任意多个具体的基本方法。
         */
        //（所有）基本方法
        abstractMethod();
        hookMethod();
        concreteMethod();
    }
    // [基本] 抽象方法，必须有子类实现
    protected abstract void abstractMethod();
    // [基本] 钩子方法，子类可以选择重写或不重写
    protected void hookMethod() {
    }
    // [基本] 具体方法，子类不可修改
    private final void concreteMethod() {
        System.out.println("抽象类中的具体方法");
    }
}
