import java.awt.Color;

/**
 * @author Love-OverFlow
 * @date 2023/7/17
 */
public class BlackChess implements Chess { // 黑棋享元类
    // 内部状态，共享
    private final Color color = Color.BLACK;

    private final String sharp = "圆形";

    @Override
    public void draw(int x, int y) {
        System.out.printf("%s黑色棋子置于（%d，%d）处%n", sharp, x, y);
    }
}
