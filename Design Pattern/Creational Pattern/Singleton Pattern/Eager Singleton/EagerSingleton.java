public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        // 初始化一些东西
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
