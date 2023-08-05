/**
 * @author Love-OverFlow
 * @date 2023/7/6
 */
// 抽象构件Component：可以是抽象接口也可以是抽象类
public abstract class Component {

    private String name; // 设备或部门名称

    public String getName() {
        return name;
    }

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component component); // 添加设备或子部门
    public abstract void remove(Component component); // 移除设备或子部门
    public abstract void display(int depth); // 查询该节点下所有“设备”和“部门”
}
