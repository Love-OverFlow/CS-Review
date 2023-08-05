public class EmailSender implements Sender{
    @Override
    public void Send() {
        System.out.println("发送邮件");
    }
}
public class SmsSender implements Sender{
    @Override
    public void Send() {
        System.out.println("发送短信");
    }
}

public class ExpressSender implements Sender {
    @Override
    public void Send() {
        System.out.println("发送快递");
    }
}