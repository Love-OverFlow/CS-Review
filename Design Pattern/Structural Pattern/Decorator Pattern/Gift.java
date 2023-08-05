/**
 * @author Love-OverFlow
 * @date 2023/7/9
 */
public class Gift implements Goods {
    private String desc;

    public Gift(String name) {
        desc = name;
    }

    @Override
    public String GetDesc() {
        return desc;
    }
}
