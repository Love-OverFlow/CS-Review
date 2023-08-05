/**
 * @author Love-OverFlow
 * @date 2023/8/4
 */

// 也可以用 abstract 写法
public interface Colleague {
    // 发送信息给其他员工, 通过中介者进行
    void message();
    // 员工自己的具体业务处理逻辑
    void selfMethod();
}

