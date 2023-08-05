/**
 * @author Love-OverFlow
 * @date 2023/7/31
 */
public class OpenTvCommand implements Command {
    private TV tv;
    public OpenTvCommand(TV tv) {
        this.tv = tv;
    }
    public void execute() {
        tv.open();
    }
}

