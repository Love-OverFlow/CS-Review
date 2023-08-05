/**
 * @author Love-OverFlow
 * @date 2023/8/5
 */

// 被访问元素的接口
public interface Element {
    // 接受（传参）访问者对象的函数, 代表本类元素可以被访问
    void accept(Visitor visitor);
}
