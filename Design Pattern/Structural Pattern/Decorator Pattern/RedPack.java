/**
 * @author Love-OverFlow
 * @date 2023/7/9
 */
public class RedPack extends Pack {
    public RedPack(Goods g) {
        super(g);
    }

    @Override
    public String GetDesc() {
        return super.GetDesc() + ", with Red Package";
    }
}
