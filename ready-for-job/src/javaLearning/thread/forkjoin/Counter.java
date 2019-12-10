package javaLearning.thread.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author zhiwen.qi
 * @description  统计器继承RecursiveTask并覆写compute方法
 * @date 2019/11/20
 */
public class Counter extends RecursiveTask<Integer> {

    public static final int THRESHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private Filter filter;

    public Counter(double[] values, int from, int to, Filter filter) {
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    @Override
    protected Integer compute() {
        if (to - from < THRESHOLD) {
            int count = 0;
            for (int i=from;i < to;i++) {
                if (filter.accept(values[i])) {
                    count++;
                }
            }
            return count;
        }else {
            int mid = (from + to) / 2;
            Counter first = new Counter(values,from,mid,filter);
            Counter second = new Counter(values,mid,to,filter);
            invokeAll(first,second);
            return first.join() + second.join();
        }
    }
}
