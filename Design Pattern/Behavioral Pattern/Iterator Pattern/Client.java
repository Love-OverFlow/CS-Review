/**
 * @author Love-OverFlow
 * @date 2023/8/3
 */
public class Client {
    public static void main(String[] args) {
        AggregateIterable aggregate = new ConcreteAggregate();
        aggregate.add("自己实现的支持迭代器的容器");
        aggregate.add("1");
        aggregate.add("2");
        // 遍历
        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
