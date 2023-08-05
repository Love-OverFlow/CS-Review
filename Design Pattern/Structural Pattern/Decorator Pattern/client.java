/**
 * @author Love-OverFlow
 * @date 2023/7/9
 */
public class client {
    public static void main(String[] args) {
        var gift = new Gift("flower");
        Pack pack, RedPack, SignedPack;

        pack = new Pack(gift);
        System.out.println(pack.GetDesc());
        // [OUT] Pack flower

        RedPack = new RedPack(gift);
        System.out.println(RedPack.GetDesc());
        // [OUT] Pack flower, with Red Package

        SignedPack = new SignedPack(gift, "me");
        System.out.println(SignedPack.GetDesc());
        // [OUT] Pack flower, with signature: me

        // 嵌套装饰
        SignedPack = new SignedPack(RedPack, "me");
        System.out.println(SignedPack.GetDesc());
        // [OUT] Pack Pack flower, with Red Package, with signature: me
    }
}