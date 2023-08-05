/**
 * @author Love-OverFlow
 * @date 2023/7/6
 */

// 接口实现
// public interface Paper {
//     void construct(); // 使用笔在纸上书写
// }

// 抽象类实现
public abstract class Paper {
    protected Pen pen;

    public abstract void construct();

    public Paper(Pen p) {
        pen = p;
    }
}
