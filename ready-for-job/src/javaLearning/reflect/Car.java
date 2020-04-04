package javaLearning.reflect;

/**
 * @author zhiwen.qi
 * @description
 * @date 2020/4/4 9:42
 */
public class Car {

    private String brand;

    private int speed;

    private String color;

    public Car() {
    }

    public Car(String brand, String color, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    protected void drive() {
        System.out.println("protected method drive, car color is " + color);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
