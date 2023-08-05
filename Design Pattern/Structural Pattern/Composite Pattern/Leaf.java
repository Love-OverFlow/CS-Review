/**
 * @author Love-OverFlow
 * @date 2023/7/6
 */

// 叶子节点Leaf类：树叶节点，模拟某个单台设备
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("叶子节点（设备）不能再挂载设备");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("叶子节点（设备）不能再移除设备");
    }

    @Override
    public void display(int depth) {
        // 输出子叶子节点，这里直接输出设备名称
        for (int i = 0; i < depth; i++) {
            System.out.print("*"); // 星号表示当前深度
        }
        System.out.println(getName());
    }
}
