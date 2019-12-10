package javaLearning.thread.syn;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/18
 */
public class DemoCount {

    private static int a = 0;

    private static AtomicInteger an = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        unsyn();
//        atom();
    }

    public static void unsyn() throws InterruptedException {
        System.err.println("LOL");
        int n = 50000;
        while (n > 0) {
            unsynAddCount();
            n--;
        }
        Thread.sleep(5000);
        System.err.println(a);
    }

    public static void unsynAddCount() {
        new Thread(() -> a++).start();
    }

    public static void atom() throws InterruptedException {
        System.err.println("LOL");
        int n = 50000;
        while (n > 0) {
            atomAdd();
            n--;
        }
        Thread.sleep(2000);
        System.err.println(an.get());
    }

    public static void atomAdd() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                an.getAndIncrement();
            }
        }).start();
    }



}
