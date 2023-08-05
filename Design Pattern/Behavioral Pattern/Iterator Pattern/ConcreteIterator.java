/**
 * @author Love-OverFlow
 * @date 2023/8/3
 */
public class ConcreteIterator implements Iterator { // 具体容器对应的迭代器
    private ConcreteAggregate aggregate;
    private int index; // 迭代开始下标
    private int size; // 集合长度
    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
        this.index = 0;
        this.size = aggregate.size();
    }
    @Override
    public Object next() {
        return aggregate.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }
}
