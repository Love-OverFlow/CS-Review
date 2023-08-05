/**
 * @author Love-OverFlow
 * @date 2023/7/9
 */
public class SignedPack extends Pack{
    private String signature;
    public SignedPack(Goods g, String s) {
        super(g);
        signature = s;
    }

    @Override
    public String GetDesc() {
        return super.GetDesc() + ", with signature: " + signature;
    }
}
