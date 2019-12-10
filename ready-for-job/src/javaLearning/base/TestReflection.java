package javaLearning.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/31
 */
public class TestReflection {

    public static void main(String[] args) {
//        know1();
//        know2();
        know3();
    }

    /**
     * 利用obj.getClass()可获取到obj对象所属的类；
     * 使用Class.forName(String className)可以获取到指定地方的类对象，然后通过newInstance()方法可通过类创建实例对象。
     */
    public static void know1() {
        Employee e = new Employee("Jack Hie", 12000, new Date());
        Class c1 = e.getClass();
        if (c1 == Employee.class) {
            System.out.println("c1 is " + Employee.class.getName());
        }

        String className = "javaLearning.base.Employee";
        try {
            Class c2 = Class.forName(className);
            Employee e2 = (Employee)c2.newInstance();
            System.out.println("c2-------"+c2.getName());
            System.out.println("e2-------"+e2.name);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 使用反射修改类的属性或方法
     */
    public static void know2() {
        Employee e = new Employee("Jack Hie", 12000, new Date());
        Class c = e.getClass();
        try {
            Field[] fields = c.getDeclaredFields();
            Method[] methods =c.getDeclaredMethods();
            Constructor[] constructors =c.getConstructors();
            Field fName = c.getDeclaredField("name");
            fName.setAccessible(true);
            Object value = fName.get(e);
            System.out.println("before change---" + value);
            fName.set(e,"Henry Nis");
            System.out.println("after change---" + e.name);
        } catch (NoSuchFieldException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 利用反射调用类的方法
     */
    public static void know3() {
        Employee e = new Employee("Jack Hie", 12000, new Date());
        Class c = e.getClass();
        try {
            Method m = c.getMethod("getName", boolean.class);
            String name = (String) m.invoke(e,true);
            System.out.println("invoke getName result------" + name);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }


}
