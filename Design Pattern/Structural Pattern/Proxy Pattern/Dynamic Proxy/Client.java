import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Love-OverFlow
 * @date 2023/7/18
 */
public class Client {
    public static void main(String[] args) {
        String name = "Alice";

        /*********** JDK 动态代理 ***********/
        MyBuyer buyer = new MyBuyer(name); // 这里声明成 接口类型 Buyer 也可以
        Buyer proxy = (Buyer) Proxy.newProxyInstance(
                buyer.getClass().getClassLoader(), buyer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        Object obj;
                        // 在 buyTicket() 调用前后添加功能，来模拟 BuyerProxy 代理类
                        if ("buyTicket".equals(method.getName())) {
                            System.out.println("搜集信息，开始比价"); // 调用前
                            obj = method.invoke(buyer, args);
                            System.out.println("购票成功，短信通知"); // 调用后
                        } else {
                            obj = method.invoke(buyer, args); // 不是 buyTicket(), 不添加功能
                        }
                        return obj;
                    }
                });
        // 使用动态生成的代理类完成操作
        proxy.login(name, "*(&^&%^");
        proxy.buyTicket();
    }

    /**
     * [OUT]
     * 用户：Alice 使用密码：*(&^&%^ 登录成功
     * 搜集信息，开始比价
     * Alice 正在购票
     * 购票成功，短信通知
     */
}
