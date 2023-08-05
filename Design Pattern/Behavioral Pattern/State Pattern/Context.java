/**
 * @author Love-OverFlow
 * @date 2023/8/4
 */
public class Context {
    private State state;

    public Context() {
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle();
    }
}
