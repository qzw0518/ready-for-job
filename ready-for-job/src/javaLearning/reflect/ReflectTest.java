package javaLearning.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhiwen.qi
 * @description
 * @date 2020/4/4 9:46
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("javaLearning.reflect.Car");

        Constructor cons = clazz.getDeclaredConstructor(null);
        Car carByCons = (Car) cons.newInstance();
        Car carByNew = new Car("BMW", "White", 230);

        System.out.println("carByCons---" + carByCons.getBrand() + " " + carByCons.getSpeed());
        System.out.println("carByNew---" + carByNew.getBrand() + " " + carByNew.getSpeed());


        Method setBrand = clazz.getDeclaredMethod("setBrand", String.class);
        setBrand.invoke(carByCons, "Benz");
        setBrand.invoke(carByNew, "BMW+");

        Method setSpeed = clazz.getDeclaredMethod("setSpeed", int.class);
        setSpeed.invoke(carByCons, 200);
        setSpeed.invoke(carByNew, 240);

        System.out.println("after reflect");
        System.out.println("carByCons---" + carByCons.getBrand() + " " + carByCons.getSpeed());
        System.out.println("carByNew---" + carByNew.getBrand() + " " + carByNew.getSpeed());


        Field color = clazz.getDeclaredField("color");
        color.setAccessible(true);
        color.set(carByCons, "Blue");

        Method drive = clazz.getDeclaredMethod("drive");
        drive.setAccessible(true);
        drive.invoke(carByCons, null);
    }


}
