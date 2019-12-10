package javaLearning.thread.lock;

import java.util.concurrent.locks.Lock;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/4
 */
public class AddCount implements Runnable {

    private TestLock testLock;

    public AddCount(TestLock testLock) {
        this.testLock = testLock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        testLock.lockMethod();
    }
}
