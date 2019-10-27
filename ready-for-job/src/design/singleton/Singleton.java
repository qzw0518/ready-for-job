package design.singleton;

/**
 * @author zhiwen.qi
 * @description 单例模式：Lazy初始化（第一次调用才初始化，避免内存浪费）；线程不安全，因为getInstance方法没有加synchronized
 * @date 2019/10/27
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
