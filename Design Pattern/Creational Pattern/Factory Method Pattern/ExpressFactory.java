public class ExpressFactory implements SenderFactory{
    @Override
    public Sender Produce() {
        return new ExpressSender();
    }
}
