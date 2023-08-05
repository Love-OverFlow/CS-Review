/**
 * @author Love-OverFlow
 * @date 2023/7/25
 */
public class Junior extends Handler {
    Junior() {
        super(Handler.LEVEL_2_REQUEST);
    }

    @Override
    protected void response(Request request) {
        System.out.println("--------难度级别为2的请求-------");
        System.out.println(request.getContent());
        System.out.println("中级工程师处理结果: 已处理\n");
    }
}
