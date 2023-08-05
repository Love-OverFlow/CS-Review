public class CloseTvCommand implements Command {
    private TV tv;

    public CloseTvCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.close();
    }
}
