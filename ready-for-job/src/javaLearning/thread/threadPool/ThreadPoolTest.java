package javaLearning.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/20
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("task");
            }
        };
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(r);
        pool.shutdown();
    }

}
