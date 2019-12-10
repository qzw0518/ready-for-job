package design.abstractFactory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class Yellow implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Yellow :: fill() method");
    }
}
