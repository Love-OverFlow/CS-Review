/**
 * @author Love-OverFlow
 * @date 2023/8/4
 */
public interface State {
    /**
     * 改变当前上下文 context 使用的状态
     */
    void setCurrentState(Context ctx);

    /**
     * 不同状态下的行为, 留给不同的具体状态类实现
     */
    void handle();
}
