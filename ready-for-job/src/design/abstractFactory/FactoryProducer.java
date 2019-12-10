package design.abstractFactory;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/27
 */
public class FactoryProducer {

    public static AbstracFactory getFactory(String factoryName) {
        if ("shape".equalsIgnoreCase(factoryName)) {
            return new ShapeFactory();
        }else if ("color".equalsIgnoreCase(factoryName)) {
            return new ColorFactory();
        }
        return null;
    }
}
