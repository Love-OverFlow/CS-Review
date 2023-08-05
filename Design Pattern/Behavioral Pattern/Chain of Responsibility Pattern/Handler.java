/**
 * @author Love-OverFlow
 * @date 2023/7/25
 */
abstract class Handler {
    final static int LEVEL_1_REQUEST = 1; // 难度级别为1
    final static int LEVEL_2_REQUEST = 2; // 难度级别为2
    final static int LEVEL_3_REQUEST = 3; // 难度级别为3
    // 给实现类对象的成员变量, 表示自己能处理的级别
    private int level = 0;
    // 责任传递，下一个责任人是谁
    private Handler nextHandler;

    // 实现类对象在初始化时要说明一下自己能处理哪些请求
    Handler(int level) {
        this.level = level;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // 对 Request 的链式处理逻辑, final 关键字声明不允许被子类覆盖
    final void HandleMessage(Request request) {
        // 如果请求级别小于当前对象可以处理的级别就直接处理
        if (request.getLevel() <= this.level) {
            this.response(request);
        } else {
            if (this.nextHandler != null) { // 有后续环节，请求传递
                this.nextHandler.HandleMessage(request); // 递归
            } else { // 无后续环节了，按照不同意处理
                System.out.println("--------难度级别为" + request.getLevel() + "的请求-------");
                System.out.println("---抱歉，没有工程师可以处理---\n");
            }
        }
    }

    // 每个实现类自己定义一套具体的请求处理逻辑
    protected abstract void response(Request request);
}
