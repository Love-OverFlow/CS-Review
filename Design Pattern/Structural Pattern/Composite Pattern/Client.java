/**
 * @author Love-OverFlow
 * @date 2023/7/6
 */
public class Client {
    public static void main(String[] args) {
        // 创建根节点, 并挂载两个设备
        Composite root = new Composite("综合实验室");
        root.add(new Leaf("综合设备1"));
        root.add(new Leaf("综合设备2"));

        // 创建二级实验室及其设备
        Composite subTree1 = new Composite("化学实验室");
        subTree1.add(new Leaf("试管"));
        subTree1.add(new Leaf("烧杯"));
        subTree1.add(new Leaf("锥形瓶"));
        root.add(subTree1); // 在上级节点挂载

        // 另一个并列的二级实验室
        Composite subTree2 = new Composite("物理实验室");
        subTree2.add(new Leaf("单刀单至开关设备"));
        subTree2.add(new Leaf("电磁箱"));
        root.add(subTree2); // 在上级节点挂载

        // 二级实验室 - 物理实验室 的子部门
        Composite subsubTree = new Composite("精密仪器实验组");
        subsubTree.add(new Leaf("精密光学测量仪"));
        subsubTree.add(new Leaf("精密机床"));
        subTree2.add(subsubTree); // 在上级节点挂载

        root.display(0);
    }
}

// [OUT]
// 综合实验室
// *综合设备1
// *综合设备2
// *化学实验室
// **试管
// **烧杯
// **锥形瓶
// *物理实验室
// **单刀单至开关设备
// **电磁箱
// **精密仪器实验组
// ***精密光学测量仪
// ***精密机床
