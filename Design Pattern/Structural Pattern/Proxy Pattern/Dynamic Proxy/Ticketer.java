/**
 * @author Love-OverFlow
 * @date 2023/7/18
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/*
  因为 spring 包含 cglib 的功能，所以引入 spring-core 的 jar 包也可以:
  import org.springframework.cglib.proxy.Enhancer;
  import org.springframework.cglib.proxy.MethodInterceptor;
  import org.springframework.cglib.proxy.MethodProxy;
 */

import java.lang.reflect.Method;

/*
 * 没有实现任何接口的购票类，功能和 MyBuyer 完全一致，只是没有实现接口
 */
public class Ticketer {
    private String name; // 模拟当前购票人

    public Ticketer(String name) {
        this.name = name;
    }

    public void login(String username, String password) {
        System.out.println("用户：" + username + " 使用密码：" + password + " 登录成功");
    }

    public void buyTicket() {
        System.out.println(name + " 正在购票");
    }

    public static void main(String[] args) {
        String name = "Alice";
        Ticketer buyer = new Ticketer(name);

        // 工具类
        Enhancer enhancer = new Enhancer();
        // 设置代理对象的父类
        enhancer.setSuperclass(buyer.getClass());
        // 设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(
                    Object o, Method method, Object[] objects, MethodProxy methodProxy)
                    throws Throwable {
                Object obj;
                // 在 buyTicket() 调用前后添加功能，来模拟 BuyerProxy 代理类
                if ("bugTicket".equals(method.getName())) {
                    System.out.println("搜集信息，开始比价");
                    obj = method.invoke(buyer, args);
                    System.out.println("购票成功，短信通知");
                } else {
                    obj = method.invoke(buyer, objects);
                }
                return obj;
            }
        });
        // 创建子类（代理对象）
        Ticketer ticketerProxy = (Ticketer) enhancer.create();
        ticketerProxy.login(name, "*(&^&%^");
        ticketerProxy.buyTicket();
    }
    /**
     * [OUT]
     * 和 JDK 动态代理方法输出完全一致
     */
}
