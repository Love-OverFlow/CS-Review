import java.awt.Color;

/**
 * @author Love-OverFlow
 * @date 2023/7/17
 */
public class Client {
    public static void main(String[] args) {
        // 下黑子
        Chess backChess1 = ChessFactory.getChess(Color.BLACK);
        backChess1.draw(2, 5);

        // 下白子
        Chess whiteChess = ChessFactory.getChess(Color.WHITE);
        whiteChess.draw(3, 5);

        // 下黑子
        Chess backChess2 = ChessFactory.getChess(Color.BLACK);
        backChess2.draw(2, 6);

        System.out.printf(
                "backChess1:%d | whiteChess:%d | backChess2:%d%n",
                backChess1.hashCode(), whiteChess.hashCode(), backChess2.hashCode());
    }

    /**
     * [OUT]
     * 圆形黑色棋子置于（2，5）处
     * 圆形白色棋子置于（3，5）处
     * 圆形黑色棋子置于（2，6）处
     * backChess1:1751075886 | whiteChess:2108649164 | backChess2:1751075886
     */
}
