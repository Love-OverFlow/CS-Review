/**
 * @author Love-OverFlow
 * @date 2023/8/4
 */

// 视频类, 我们要应用备忘录模式的对象
public class Video {
    private String state;

    public Video(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    // 加入备忘录模式只需要在原来对象的基础上添加两个方法:
    // 1. 构建副本的方法
    public VideoMemento saveMemento() {
        return new VideoMemento(this.state);
    }

    // 2. 从副本中恢复状态
    public void undoFromMemento(VideoMemento v) {
        this.state = v.getState();
    }
}
