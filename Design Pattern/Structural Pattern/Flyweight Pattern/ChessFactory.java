import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Love-OverFlow
 * @date 2023/7/17
 */
public class ChessFactory { // 享元对象工厂
    private static final Map<Color, Chess> chessMap = new HashMap<>();

    public static Chess getChess(Color color) {
        Chess chess = chessMap.get(color);
        if (chess == null) {
            if (color == Color.WHITE) {
                chess = new WhiteChess();
            } else {
                chess = new BlackChess();
            }
            chessMap.put(color, chess);
        }
        return chess;
    }
}
