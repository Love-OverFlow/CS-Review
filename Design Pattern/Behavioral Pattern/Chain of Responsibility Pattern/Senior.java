/**
 * @author Love-OverFlow
 * @date 2023/7/25
 */
public class Senior extends Handler {
    Senior() {
        super(Handler.LEVEL_3_REQUEST);
    }

    @Override
    protected void response(Request request) {
        System.out.println("--------难度级别为3的请求-------");
        System.out.println(request.getContent());
        System.out.println("高级工程师处理结果: 已处理\n");
    }
}
