/**
 * @author Love-OverFlow
 * @date 2023/7/28
 */

// 在客户端实际接收请求的封装类，封装所有通用基础逻辑
public class Context {
    private Strategy strategy; // 将具体的排序请求委托给传入的算法实现类

    public Context(Strategy strategy) { // 支持在创建时动态传入不同的排序算法
        this.strategy = strategy;
    }

    public void getOrder() {
        this.strategy.algorithm();
    }
}
