package design.abstractFactory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstracFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();
        AbstracFactory colorFactory = FactoryProducer.getFactory("color");
        Color color1 = colorFactory.getColor("blue");
        color1.fill();
    }
}
