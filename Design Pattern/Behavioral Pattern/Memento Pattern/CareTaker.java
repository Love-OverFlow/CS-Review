import java.util.ArrayList;
import java.util.List;

/**
 * @author Love-OverFlow
 * @date 2023/8/4
 */
public class CareTaker { // 守护者对象, 管理副本对象
    private List<VideoMemento> list = new ArrayList<>();

    public void add(VideoMemento videoMemento) {
        list.add(videoMemento);
    }

    public VideoMemento get(int index) {
        return list.get(index);
    }
}
