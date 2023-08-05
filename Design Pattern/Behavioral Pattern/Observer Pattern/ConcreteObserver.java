/**
 * @author Love-OverFlow
 * @date 2023/7/25
 */
/**
 * 具体观察者（订阅者）
 */
class ConcreteObserver implements Observer {
    private int number;
    public ConcreteObserver(int number) {
        this.number = number;
    }
    @Override
    public void update() { // 更新之后，主题(发布者)主动执行订阅（通知）方法
        System.out.println(number + " 号收到了通知");
    }
}