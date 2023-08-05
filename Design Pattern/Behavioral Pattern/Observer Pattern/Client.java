/**
 * @author Love-OverFlow
 * @date 2023/7/25
 */
public class Client {
    public static void main(String[] args) {
        // 创建主题（发布者）
        ConcreteSubject subject = new ConcreteSubject();
        // 创建观察者（订阅者）
        Observer observer1 = new ConcreteObserver(1);
        Observer observer2 = new ConcreteObserver(2);
        // 关联订阅
        subject.attach(observer1);
        subject.attach(observer2);
        // 改变主题（发布者）状态，发送通知
        subject.change();
    }
    /**
     * [OUT]
     * 1 号收到了通知
     * 2 号收到了通知
     */
}
