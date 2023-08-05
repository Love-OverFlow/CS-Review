/**
 * @author Love-OverFlow
 * @date 2023/8/4
 */
public class Client {
    public static void main(String[] args) {
        // 声明上下文对象
        Context ctx = new Context();
        // 声明 start 状态对象
        State state = new StartState();
        // 利用状态切换
        state.setCurrentState(ctx); // [OUT] Context is in start state
        ctx.request(); // [OUT] 开机初始状态的处理逻辑

        // 声明 stop 状态对象
        state = new StopState();
        state.setCurrentState(ctx); // [OUT] Context is in stop state
        ctx.request(); // [OUT] 停机状态的处理逻辑
    }
}
