/**
 * @author Love-OverFlow
 * @date 2023/7/16
 */
public class Client {
    public static void main(String[] args) {
        // 不使用外观模式
        var fireSystem = new FireSystem();
        var userSystem = new UserSystem();

        fireSystem.reload();
        fireSystem.fire();
        userSystem.addBlood();
        userSystem.addScore();

        System.out.println("-------------------------");

        // 使用外观模式
        var facade = new Facade(fireSystem, userSystem);
        facade.shooting(); // 射击 API
    }

}
