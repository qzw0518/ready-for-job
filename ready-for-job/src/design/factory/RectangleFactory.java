package design.factory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
