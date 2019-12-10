package design.simpleFactory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class FactoryPattern {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShapge("circle");
        Shape shape2 = factory.getShapge("rectangle");
        Shape shape3 = factory.getShapge("square");
        shape1.draw();
        shape2.draw();
        shape3.draw();
    }
}
