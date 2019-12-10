package javaLearning.classloader;

import javaLearning.classloader.referenceMorP.ConstClass;
import javaLearning.classloader.referenceMorP.SubClass;
import javaLearning.classloader.referenceMorP.SuperClass;

/**
 * @author zhiwen.qi
 * @description 被动引用的一些测试。运行时通过jvm参数-XX:+TraceClassLoading可以查看类加载的过程。
 * @date 2019/11/18
 */
public class Test1118 {

    public static void main(String[] args) {
        passiveReference_3();
    }

    /**
     * 被动引用例1.将不会输出SubClass init。
     * 对于静态字段，只有直接定义它的类才会被初始化。通过子类引用父类中的静态字段只会触发父类初始化。
     * 是否要触发子类初始化取决于虚拟机的实现。
     */
    public static void passiveReference_1() {
        System.out.println(SubClass.value);
    }

    /**
     * 被动引用例2.将不会输出SuperClass init，SuperClass类未被初始化
     */
    public static void passiveReference_2() {
        SuperClass[] sca = new SuperClass[10];
    }

    /**
     * 被动引用例3.将不会输出ConstClass init。
     * 在编译阶段通过常量传播优化，ConstClass中的常量HELLOWORLD已被存储到了Test1118的常量池中
     * 后续对ConstClass.HELLOWORLD的引用实际被转化为Test1118对自身常量池的引用。
     */
    public static void passiveReference_3() {
        System.out.println(ConstClass.HELLOWORLD);
    }
}
