package javaLearning.swingLearning.layout;

/**
 * @author zhiwen.qi
 * @description
 * @date 2020/3/6 18:48
 */
public class NameValue {
    private String name;

    private int value;

    public NameValue(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return this.value;
    }
}
