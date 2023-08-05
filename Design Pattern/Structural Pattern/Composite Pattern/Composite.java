import java.util.ArrayList;

/**
 * @author Love-OverFlow
 * @date 2023/7/6
 */

// 中间节点类，模拟某个部门
public class Composite extends Component {
    public Composite(String name) {
        super(name);
    }

    // 构建一个容器，用来保存该节点下所有的“设备”和“组织” (子树)
    private ArrayList<Component> componentArrayList = new ArrayList<>();

    // 添加 设备/部门
    @Override
    public void add(Component component) {
        this.componentArrayList.add(component);
    }

    // 移除 设备/部门
    @Override
    public void remove(Component component) {
        this.componentArrayList.remove(component);
    }

    // 递归查询该节点下的子节点
    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("*"); // 星号表示当前深度
        }
        System.out.println(getName());

        // 递归查询
        for(Component component: componentArrayList) {
            component.display(depth + 1);
        }
    }
}
