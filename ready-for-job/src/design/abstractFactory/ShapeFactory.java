package design.abstractFactory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class ShapeFactory extends AbstracFactory {
    @Override
    public Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if ("circle".equalsIgnoreCase(shape)) {
            return new Circle();
        }
        if ("square".equalsIgnoreCase(shape)) {
            return new Square();
        }
        if ("rectangle".equalsIgnoreCase(shape)) {
            return new Rectangle();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
