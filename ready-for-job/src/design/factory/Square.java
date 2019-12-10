package design.factory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square :: draw() method");
    }
}
