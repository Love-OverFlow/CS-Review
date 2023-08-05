/**
 * @author Love-OverFlow
 * @date 2023/7/6
 */
public class client {
    public static void main(String[] args) {
        Paper paper;

        // 铅笔配红纸
        paper = new RedPaper(new Pencil());
        paper.construct(); // [OUT] 铅笔书写, 写在红纸上
        // 铅笔配蓝纸
        paper = new BluePaper(new Pencil());
        paper.construct(); // [OUT] 铅笔书写, 写在蓝纸上
        // 圆珠笔配红纸
        paper = new RedPaper(new BallPen());
        paper.construct(); // [OUT] 圆珠笔书写, 写在红纸上
        // 圆珠笔配蓝纸
        paper = new BluePaper(new BallPen());
        paper.construct(); // [OUT] 圆珠笔书写, 写在蓝纸上
    }
}
