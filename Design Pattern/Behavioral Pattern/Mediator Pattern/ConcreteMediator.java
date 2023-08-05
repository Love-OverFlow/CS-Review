import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    // 管理所有处理具体业务的同事
    private List<Colleague> list = new ArrayList<>();

    @Override
    public void deal(Colleague colleague) {
        for (Colleague c : list) {
            if (c == colleague) {
                // 如果是这个发送信息的员工自身, 就跳过
                continue;
            }
            // 通知该中介者管理的其他员工, 让他们处理
            c.selfMethod();
        }
    }

    // 添加管理员工
    @Override
    public void add(Colleague colleague) {
        list.add(colleague);
    }
}
