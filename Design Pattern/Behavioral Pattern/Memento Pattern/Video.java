/**
 * @author Love-OverFlow
 * @date 2023/8/4
 */
public class  {
    private String state;

    public TimeMachine(String state) {
        this.state = state;
    }

    public Video save() {
        return new Video(this.state);
    }

    public void undoFromMemento(Video v) {
        this.state = v.getState();
    }
}
