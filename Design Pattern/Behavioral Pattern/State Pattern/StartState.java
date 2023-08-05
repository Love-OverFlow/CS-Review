public class StartState implements State {
    private String name;

    public StartState() {
        this.name = "start";
    }

    @Override
    public void setCurrentState(Context ctx) {
        ctx.setState(this);
        System.out.println("Context is in start state");
    }

    @Override
    public void handle() {
        System.out.println("开机初始状态的处理逻辑");
    }
}
