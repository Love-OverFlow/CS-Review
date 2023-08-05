public class ChangeTvCommand implements Command {
    private TV tv;

    public ChangeTvCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.change();
    }
}

