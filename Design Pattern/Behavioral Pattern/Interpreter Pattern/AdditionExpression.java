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
        if (context.getSymbol() != null) {
            return this.left.interpreter(context) + this.right.interpreter(context);
        }
        return 0;
    }
}
