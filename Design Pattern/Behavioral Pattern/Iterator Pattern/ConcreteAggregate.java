import java.util.ArrayList;

/**
 * @author Love-OverFlow
 * @date 2023/8/3
 */

// 具体的集合实现类
public class ConcreteAggregate implements AggregateIterable {
    // 底层存储结构
    private ArrayList<Object> data = new ArrayList<>();
    @Override
    public void add(Object o) {
        this.data.add(o);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this);
    }

    public int size() {
        return data.size();
    }

    public Object get(int index) {
        return data.get(index);
    }
}
