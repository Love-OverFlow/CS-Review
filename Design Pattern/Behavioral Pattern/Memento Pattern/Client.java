/**
 * @author Love-OverFlow
 * @date 2023/8/4
 */
public class Client {
    public static void main(String[] args) {
        Video video = new Video("初始状态");
        CareTaker careTaker = new CareTaker();

        // 保存副本到管理中心
        careTaker.add(video.saveMemento());

        // 修改原对象当前状态
        video.setState("中间状态");
        System.out.println(video.getState()); // [OUT] 中间状态
        // 从管理中心取出副本
        VideoMemento memento = careTaker.get(0);
        // 从副本恢复原对象的状态
        video.undoFromMemento(memento);
        System.out.println(video.getState()); // [OUT] 初始状态
    }
}
