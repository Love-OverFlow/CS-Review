/**
 * @author Love-OverFlow
 * @date 2023/7/31
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    public void execute() {
        this.receiver.doSomething();
    }
}
