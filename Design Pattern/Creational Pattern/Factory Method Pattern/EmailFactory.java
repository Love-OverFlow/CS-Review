public class EmailFactory implements SenderFactory {
    @Override
    public Sender Produce() {
        return new EmailSender();
    }
}
