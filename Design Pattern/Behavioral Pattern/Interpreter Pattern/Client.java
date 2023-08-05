import java.beans.Expression;

/**
 * @author Love-OverFlow
 * @date 2023/8/1
 */

// 客户端，创建并配置解释器，并调用其解释表达式
public class Client {
    public static void main(String[] args) {
        AbstractExpression left = new TerminalExpression(12);
        AbstractExpression right = new TerminalExpression(34);
        AbstractExpression calExpression = new AdditionExpression(left, right);
        Context context = new Context("+");
        int result = calExpression.interpreter(context);
        System.out.println(result); // [OUT] 46
    }
}
