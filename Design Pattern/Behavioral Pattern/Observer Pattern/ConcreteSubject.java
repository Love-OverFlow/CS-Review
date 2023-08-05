/**
 * @author Love-OverFlow
 * @date 2023/7/25
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题（发布者）
 */
class ConcreteSubject implements Subject {
    // 存放观察者（订阅者）
    private List<Observer> list = new ArrayList<Observer>();
    @Override
    public void attach(Observer o) {
        list.add(o);
    }
    @Override
    public void detach(Observer o) {
        list.remove(o);
    }
    @Override
    public void notifyObservers() {
        for (Observer o : list) {
            o.update();
        }
    }
    // 改变主题(发布者)状态, 并且发送通知
    public void change() {
        this.notifyObservers();
    }
}
