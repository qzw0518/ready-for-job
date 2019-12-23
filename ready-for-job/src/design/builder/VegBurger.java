package design.builder;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/12/23
 */
public class VegBurger extends Burger{
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
