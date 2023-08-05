import java.util.ArrayList;

/**
 * @author Love-OverFlow
 * @date 2023/7/25
 */
public class Client {
    public static void main(String[] args) {
        ArrayList<Request> arrayList = new ArrayList<>();
        arrayList.add(new LevelRequest(Handler.LEVEL_1_REQUEST, "1+1=？"));
        arrayList.add(new LevelRequest(Handler.LEVEL_2_REQUEST, "3*4=？"));
        arrayList.add(new LevelRequest(Handler.LEVEL_3_REQUEST, "87834*765=？"));
        arrayList.add(new LevelRequest(4, "1 << 1 =？"));
        // 定义三个责任人对象
        Handler primary = new Primary();
        Handler middle = new Junior();
        Handler senior = new Senior();
        // 设置链的调用顺序
        primary.setNextHandler(middle);
        middle.setNextHandler(senior);

        for (Request request : arrayList) {
            // 责任链中处理该请求
            primary.HandleMessage(request);
        }
    }
    /**
     * [OUT]
     * --------难度级别为1的请求-------
     * 难度级别为1的请求是：1+1=？
     * 初级工程师处理结果: 已处理
     *
     * --------难度级别为2的请求-------
     * 难度级别为2的请求是：3*4=？
     * 中级工程师处理结果: 已处理
     *
     * --------难度级别为3的请求-------
     * 难度级别为3的请求是：87834*765=？
     * 高级工程师处理结果: 已处理
     *
     * --------难度级别为4的请求-------
     * ---抱歉，没有工程师可以处理---
     */
}
