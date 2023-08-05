public class SenderFactory {
    public Sender produce(String type) {
        if (type == null) {
            return null;
        }
        return switch (type) {
            case "email" -> new EmailSender();
            case "sms" -> new SmsSender();
            case "express" -> new ExpressSender();
            default -> null;
        };
    }
}