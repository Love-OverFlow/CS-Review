public class main {
    public static void main(String[] args) {
        SenderFactory factory = new SmsFactory();
        Sender sender = factory.Produce();
        sender.Send(); // [OUT] 发送短信

        factory = new EmailFactory();
        sender = factory.Produce();
        sender.Send(); // [OUT] 发送邮件

        factory = new ExpressFactory();
        sender = factory.Produce();
        sender.Send(); // [OUT] 发送快递
    }
}