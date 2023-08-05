/**
 * @author Love-OverFlow
 * @date 2023/7/18
 */

// 购票统一接口
public interface Buyer {
    /**
     * 购票登录接口
     */
    void login(String username, String password);

    /**
     * 模拟购票接口
     */
    void buyTicket();
}
