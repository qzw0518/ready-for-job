package design.abstractFactory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class ColorFactory extends AbstracFactory{
    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if ("red".equalsIgnoreCase(color)) {
            return new Red();
        }
        if ("yellow".equalsIgnoreCase(color)) {
            return new Yellow();
        }
        if ("blue".equalsIgnoreCase(color)) {
            return new Blue();
        }
        return null;

    }
}
