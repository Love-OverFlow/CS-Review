public class main {
    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = senderFactory.produce("sms");
        sender.Send();
        sender = senderFactory.produce("email");
        sender.Send();
        sender = senderFactory.produce("express");
        sender.Send();
    }
}