import java.security.KeyStore.PrivateKeyEntry;

/**
 * @author Love-OverFlow
 * @date 2023/7/25
 */
public class LevelRequest implements Request {
    /**
     * 难度级别1--初级以上工程师解决
     * 难度级别2--中级以上工程师解决
     * 难度级别3--高级以上工程师解决
     */
    private int level;
    private String request;

    public LevelRequest(int level, String request) {
        this.level = level;
        this.request = switch (level) {
            case 1 -> "难度级别为1的请求是：" + request;
            case 2 -> "难度级别为2的请求是：" + request;
            case 3 -> "难度级别为3的请求是：" + request;
            default -> null;
        };
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public String getContent() {
        return this.request;
    }
}
