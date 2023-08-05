/**
 * @author Love-OverFlow
 * @date 2023/8/4
 */
public interface Mediator {
    // 中介者, 消息通知 api, 当员工需要转发消息时调用
    void deal(Colleague colleague);

    // 添加需要管理的员工
    void add(Colleague colleague);
}

