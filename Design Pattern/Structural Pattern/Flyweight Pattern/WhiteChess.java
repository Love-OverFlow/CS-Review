import java.awt.Color;

/**
 * @author Love-OverFlow
 * @date 2023/7/17
 */
public class WhiteChess implements Chess { // 白棋享元类
    // 内部状态，共享
    private final Color color = Color.WHITE;

    private final String sharp = "圆形";

    @Override
    public void draw(int x, int y) {
        System.out.printf("%s白色棋子置于（%d，%d）处%n", sharp, x, y);
    }
}
