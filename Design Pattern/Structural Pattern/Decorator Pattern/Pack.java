/**
 * @author Love-OverFlow
 * @date 2023/7/9
 */
public class Pack implements Goods {
    private Goods gift;

    public Pack(Goods g) {
        gift = g;
    }

    @Override
    public String GetDesc() {
        return "Pack " + gift.GetDesc();
    }
}
