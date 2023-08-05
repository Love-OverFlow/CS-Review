/**
 * @author Love-OverFlow
 * @date 2023/7/28
 */
public class Client {
    public static void main(String[] args) {
        Context c = new Context(new NaturalStrategy());
        c.getOrder(); // [OUT] 从小到大自然排序

        c = new Context(new ReverseStrategy());
        c.getOrder(); // [OUT] 逆序排列
    }
}
