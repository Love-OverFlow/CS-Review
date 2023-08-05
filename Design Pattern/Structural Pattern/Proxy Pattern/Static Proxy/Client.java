/**
 * @author Love-OverFlow
 * @date 2023/7/18
 */
public class Client {
    public static void main(String[] args) {
        String name = "Alice";

        /*********** 手动购票 ***********/
        Buyer buyer = new MyBuyer(name);
        // 登录
        buyer.login(name, "@#E@$^&");
        // 开始购票
        buyer.buyTicket();

        System.out.println("==========================================");

        /*********** 使用代理购票 ***********/
        MyBuyer myBuyer = new MyBuyer(name);
        Buyer proxyBuyer = new BuyerProxy(myBuyer);
        proxyBuyer.login(name, "@#E@$^&");
        proxyBuyer.buyTicket();
    }

    /**
     * [OUT]
     * 用户：Alice 使用密码：@#E@$^& 登录成功
     * Alice 正在购票
     * ==========================================
     * 用户：Alice 使用密码：@#E@$^& 登录成功
     * 搜集信息，开始比价
     * Alice 正在购票
     * 购票成功，短信通知
     */
}
