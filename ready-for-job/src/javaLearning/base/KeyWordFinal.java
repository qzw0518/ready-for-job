package javaLearning.base;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class KeyWordFinal {

    public static void main(String[] args) {
        final int a = 1;
        final Test test = new Test();
//        a = 2;  //报错，无法重新赋值
        test.a = 2;
        System.out.println(test.a);
    }
}

class Test {
    public int a = 1;
}
