public class main {
    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = senderFactory.produceSms();
        sender.Send();
        sender = senderFactory.produceEmail();
        sender.Send();
        sender = senderFactory.produceExpress();
        sender.Send();
    }
}