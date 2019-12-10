package javaLearning.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/4
 */
public class TestLock {
    private Lock lock = new ReentrantLock();

    public static int count = 0;

    public void lockMethod() {
        lock.lock();
        try {
            count++;
            System.out.println(count);
        }finally {
            lock.unlock();
        }
    }
}
