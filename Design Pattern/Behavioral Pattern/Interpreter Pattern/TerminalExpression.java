// 终结符表达式，代表解释的最终结果，不能被进一步解释
public class TerminalExpression extends AbstractExpression {
    private int arg;

    public TerminalExpression(int arg) {
        this.arg = arg;
    }

    @Override
    int interpreter(Context context) {
        return this.arg;
    }
}

