package design.singleton;

/**
 * @author zhiwen.qi
 * @description 单例模式（双检锁实现）
 * @date 2019/10/27
 */
public class DoubleCheckLockSingleton {
    /**加上volatile关键字是为了解决有些编译器为了性能，会将 1.分配内存->2.初始化对象->3.将对象指向刚分配的内存 步骤2，3步调换顺序
     * 于是会出现A线程执行到为实例分配内存但未初始化时，B线程调用方法发现实例不为空，使用了该实例，但是实例未初始化完成。
     * 加上volatile关键字后，重排序被禁止，所有写操作都将发生在读操作前，这样保证了有实例时对象一定初始化完成了。
     */
    private static volatile DoubleCheckLockSingleton instance;

    private DoubleCheckLockSingleton() {}

    public static DoubleCheckLockSingleton getInstance() {
        //先判断是否为空再加锁，这样后续的调用如果发现对象已存在，则直接返回，不会再加锁，避免了性能消耗
        if (instance == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }
}
