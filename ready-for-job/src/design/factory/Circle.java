package design.factory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle :: draw() method");
    }
}
