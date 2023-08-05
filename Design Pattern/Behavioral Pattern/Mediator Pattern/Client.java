/**
 * @author Love-OverFlow
 * @date 2023/8/4
 */
public class Client {
    public static void main(String[] args) {
        // 声明中介者
        Mediator mediator = new ConcreteMediator();
        // 声明不同的员工对象
        Colleague c1 = new ConcreteColleague1(mediator);
        Colleague c2 = new ConcreteColleague2(mediator);
        // 添加管理的不同员工对象
        mediator.add(c1);
        mediator.add(c2);

        // c1 发送群体消息, 中介者通知所有其他员工
        c1.message(); // [OUT] B 类员工收到消息, 正在处理
        System.out.println("-----------------");

        // c2 发送群体消息, 中介者通知其他员工
        c2.message(); // [OUT] A 类员工收到消息, 正在处理
    }
}
