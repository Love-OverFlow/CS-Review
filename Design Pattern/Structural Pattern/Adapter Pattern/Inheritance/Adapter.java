/**
 * 负责改造的适配器类
 *
 * @author Love-OverFlow
 * @date 2023/7/6
 */
public class Adapter extends Adaptee implements Target { // 继承原有类, 要对齐目标接口

    @Override
    public void targetMethod1() {
        System.out.println("前置处理, 准备调用原有类的 methodA()");
        methodA();
    }

    @Override
    public void targetMethod2() {
        System.out.println("前置处理, 准备调用原有类的 methodB()");
        methodB();
    }

    public static void main(String[] args) {
        Target target = new Adapter();
        target.targetMethod1();
        target.targetMethod2();
    }
}
