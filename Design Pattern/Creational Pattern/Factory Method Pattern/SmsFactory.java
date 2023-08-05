public class SmsFactory implements SenderFactory{
    @Override
    public Sender Produce() {
        return new SmsSender();
    }
}
