import java.util.Objects;

// 非终结符表达式，可以被进一步解释
public class AdditionExpression extends AbstractExpression {
    // 代表运算符两侧的参数，即a、b
    private AbstractExpression left;
    private AbstractExpression right;

    public AdditionExpression(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    int interpreter(Context context) {
        // 实现具体的 a +b 的解释执行操作
        if (Objects.equals(context.getSymbol(), "+")) {
            int a = this.left.interpreter(context);
            int b = this.right.interpreter(context);
            // 二进制实现加法
            while (b != 0) {
                int c = (a & b) << 1;
                a ^= b;
                b = c;
            }
            return a;
        }
        return 0;
    }
}
