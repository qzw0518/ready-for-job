package javaLearning.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @author zhiwen.qi
 * @description 分支合并计算1000w个[0,1)随机数中大于0.5的个数。
 * @date 2019/11/20
 */
public class ForkJoinTest {

    public static void main(String[] args) {
        final int SIZE = 10000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Math.random();
        }
        Counter counter = new Counter(numbers, 0, numbers.length, new Filter() {
            @Override
            public boolean accept(double t) {
                return t > 0.5;
            }
        });
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}
