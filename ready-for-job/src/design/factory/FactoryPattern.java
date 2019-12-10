package design.factory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class FactoryPattern {

    public static void main(String[] args) {
        ShapeFactory factory1 = new CircleFactory();
        Shape shape1 = factory1.createShape();
        shape1.draw();
        ShapeFactory factory2 = new SquareFactory();
        Shape shape2 = factory2.createShape();
        shape2.draw();
        ShapeFactory factory3 = new RectangleFactory();
        Shape shape3 = factory3.createShape();
        shape3.draw();
    }
}
