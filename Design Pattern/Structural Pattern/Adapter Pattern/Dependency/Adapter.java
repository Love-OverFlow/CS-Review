/**
 * 负责改造的适配器类
 *
 * @author Love-OverFlow
 * @date 2023/7/6
 */
public class Adapter implements Target {
    private Adaptee adaptee; // 适配器内部持有一个原有类的实例

    public Adapter() {
        adaptee = new Adaptee();
    }

    @Override
    public void targetMethod1() {
        System.out.println("前置处理, 准备调用原有类的 methodA()");
        adaptee.methodA(); // 委托内部实例去调用方法
    }

    @Override
    public void targetMethod2() {
        System.out.println("前置处理, 准备调用原有类的 methodB()");
        adaptee.methodB();
    }

    public static void main(String[] args) {
        Target target = new Adapter();
        target.targetMethod1();
        target.targetMethod2();
    }
}
