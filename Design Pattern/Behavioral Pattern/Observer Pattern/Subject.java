/**
 * @author Love-OverFlow
 * @date 2023/7/25
 */

// 抽象主题（发布者接口）
interface Subject {
    // 添加观察者（订阅者）
    public void attach(Observer o);
    // 删除观察者（订阅者）
    public void detach(Observer o);
    // 通知所有观察者（订阅者）
    public void notifyObservers();
}
