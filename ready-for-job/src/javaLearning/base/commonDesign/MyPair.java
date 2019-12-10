package javaLearning.base.commonDesign;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/3
 */
public class MyPair<T> {

    private T first;

    private T second;

    public MyPair() {
        this.first = null;
        this.second = null;
    }

    public MyPair(T first, T second) {
        this.first = first;
        this.second = second;
    }


    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
