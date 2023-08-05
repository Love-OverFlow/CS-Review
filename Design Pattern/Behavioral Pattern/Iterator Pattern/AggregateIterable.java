/**
 * @author Love-OverFlow
 * @date 2023/8/3
 */
public interface AggregateIterable { // 所有支持要迭代器的容器都应该实现该接口
    void add(Object o);
    Iterator iterator();
}
