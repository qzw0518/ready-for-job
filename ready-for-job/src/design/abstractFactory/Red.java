package design.abstractFactory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class Red implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Red :: fill() method");
    }
}
