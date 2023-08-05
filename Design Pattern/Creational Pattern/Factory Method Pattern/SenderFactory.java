public class SenderFactory {
    public Sender produceSms(){
        return new SmsSender();
    }

    public Sender produceEmail(){
        return new EmailSender();
    }

    public Sender produceExpress() {
        return new ExpressSender();
    }
}