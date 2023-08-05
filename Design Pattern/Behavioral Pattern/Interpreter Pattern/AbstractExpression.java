// 抽象表达式接口，所有具体表达式都要实现该接口
public abstract class AbstractExpression {
    // 解释器接口
    abstract int interpreter(Context context);
}

