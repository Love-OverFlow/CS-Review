/**
 * @author Love-OverFlow
 * @date 2023/7/31
 */
public class TVRemoteControl { // 最外层发送者对象
    private Command openTvCommand;
    private Command closeTvCommand;
    private Command changeTvCommand;
    public TVRemoteControl(Command openTvCommand, Command closeTvCommand, Command changeTvCommand) {
        this.openTvCommand = openTvCommand;
        this.closeTvCommand = closeTvCommand;
        this.changeTvCommand = changeTvCommand;
    }

    // 打开电视
    public void open() {
        openTvCommand.execute();
    }
    // 关闭电视
    public void close() {
        closeTvCommand.execute();
    }
    // 换频道
    public void change() {
        changeTvCommand.execute();
    }
}
