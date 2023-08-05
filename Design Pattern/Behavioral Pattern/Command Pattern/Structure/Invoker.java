/**
 * @author Love-OverFlow
 * @date 2023/7/31
 */

class Invoker { // 发送者
    // 持有命令者的引用
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    // 运行 api
    public void action() {
        this.command.execute();
    }
}
