/**
 * @author Love-OverFlow
 * @date 2023/7/25
 */
public class Primary extends Handler {
    Primary() {
        super(Handler.LEVEL_1_REQUEST);
    }

    @Override
    protected void response(Request request) {
        System.out.println("--------难度级别为1的请求-------");
        System.out.println(request.getContent());
        System.out.println("初级工程师处理结果: 已处理\n");
    }
}
