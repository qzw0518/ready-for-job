package design.builder;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/12/23
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
