package javaLearning.classloader.referenceMorP;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/18
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "Hello world";
}
