package design.builder;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/12/23
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
