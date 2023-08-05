/**
 * @author Love-OverFlow
 * @date 2023/7/31
 */
public class Client {
    public static void main(String[] args) {
        // 创建接收者
        Receiver receiver = new Receiver();
        // 创建命令者对象，设定接收者
        Command command = new ConcreteCommand(receiver);
        // 创建请求者，设定使用命令者
        Invoker invoker = new Invoker(command);
        // 执行公开的 api 方法
        invoker.action(); // [OUT] 收到命令, 接收者执行业务逻辑
    }
}
