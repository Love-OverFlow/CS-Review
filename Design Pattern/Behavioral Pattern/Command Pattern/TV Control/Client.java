/**
 * @author Love-OverFlow
 * @date 2023/7/31
 */
public class Client {
    public static void main(String[] args) {
        TV tv = new TV();
        Command openTvCommand = new OpenTvCommand(tv);
        Command closeTvCommand = new CloseTvCommand(tv);
        Command changeTvCommand = new ChangeTvCommand(tv);
        var control = new TVRemoteControl(openTvCommand, closeTvCommand, changeTvCommand);
        control.open(); // [OUT] 打开电视机
        control.change(); // [OUT] 切换电视频道
        control.close(); // [OUT] 关闭电视机
    }
}
