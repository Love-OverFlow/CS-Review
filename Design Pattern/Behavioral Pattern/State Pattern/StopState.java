/**
 * @author Love-OverFlow
 * @date 2023/8/4
 */
public class StopState implements State {
    private String name;

    public StopState() {
        this.name = "stop";
    }

    @Override
    public void setCurrentState(Context ctx) {
        ctx.setState(this);
        System.out.println("Context is in stop state");
    }

    @Override
    public void handle() {
        System.out.println("停机状态的处理逻辑");
    }
}

