package design.abstractFactory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public abstract class AbstracFactory {
    public abstract Shape getShape(String shape);
    public abstract Color getColor(String color);
}
