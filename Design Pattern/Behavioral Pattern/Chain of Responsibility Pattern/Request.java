/**
 * @author Love-OverFlow
 * @date 2023/7/25
 */
public interface Request { // 请求接口
    // 获取请求级别
    int getLevel();

    // 获取要请求的内容
    String getContent();
}
