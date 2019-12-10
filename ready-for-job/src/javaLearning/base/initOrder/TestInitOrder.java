package javaLearning.base.initOrder;

/**
 * @author zhiwen.qi
 * @description 静态代码块->构造代码块->构造函数->普通代码块
 * @date 2019/11/20
 */
public class TestInitOrder {

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
    }

    private int amount = 10;

    private static double price = 20.25;

    private static TestInitOrder testInitOrder = new TestInitOrder();

    public TestInitOrder() {
        System.out.println("构造方法");
        System.out.println("数量：" + amount + " 价格：" + price);
    }

    public static void main(String[] args) {
        staticFunc();
    }

    public static void staticFunc(){
        System.out.println("静态方法");
    }
}
