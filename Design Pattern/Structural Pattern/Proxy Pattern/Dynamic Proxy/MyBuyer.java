/**
 * @author Love-OverFlow
 * @date 2023/7/18
 */

// 实际购票类
public class MyBuyer implements Buyer {
    private String name; // 模拟当前购票人

    public MyBuyer(String name) {
        this.name = name;
    }

    @Override
    public void login(String username, String password) {
        System.out.println("用户：" + username + " 使用密码：" + password + " 登录成功");
    }

    @Override
    public void buyTicket() {
        System.out.println(name + " 正在购票");
    }
}
