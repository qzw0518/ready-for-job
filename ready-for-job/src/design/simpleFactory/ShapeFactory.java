package design.simpleFactory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class ShapeFactory {

    public Shape getShapge(String shapeType) {
        if (shapeType == null) {
            return  null;
        }
        if ("CIRCLE".equalsIgnoreCase(shapeType)) {
            return new Circle();
        }
        if ("SQUARE".equalsIgnoreCase(shapeType)) {
            return new Square();
        }
        if ("RECTANGLE".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        }
        return null;
    }
}
