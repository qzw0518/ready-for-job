package design.builder;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/12/23
 */
public abstract class ColdDrink implements Item{

    @Override
    public abstract float price();

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
