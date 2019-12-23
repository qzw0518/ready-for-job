package design.builder;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/12/23
 */
public abstract class Burger implements Item{

    @Override
    public abstract float price();


    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
