/**
 * @author Love-OverFlow
 * @date 2023/7/18
 */

// 代理购票类
public class BuyerProxy implements Buyer {
    private MyBuyer buyer;

    public BuyerProxy(MyBuyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public void login(String username, String password) {
        this.buyer.login(username, password);
    }

    @Override
    public void buyTicket() {
        before();
        this.buyer.buyTicket();
        after();
    }

    private void before() {
        System.out.println("搜集信息，开始比价");
    }

    private void after() {
        System.out.println("购票成功，短信通知");
    }
}
