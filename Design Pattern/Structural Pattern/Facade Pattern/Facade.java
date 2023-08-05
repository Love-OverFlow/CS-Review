/**
 * @author Love-OverFlow
 * @date 2023/7/16
 */
public class Facade {
    // 被委托的对象
    private FireSystem fireSystem;
    private UserSystem userSystem;

    public Facade(FireSystem fireSystem, UserSystem userSystem) {
        this.fireSystem = fireSystem;
        this.userSystem = userSystem;
    }

    // 模拟射击的门面接口 API
    public void shooting() {
        fireSystem.reload();
        fireSystem.fire();
        userSystem.addBlood();
        userSystem.addScore();
    }
}
