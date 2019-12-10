package javaLearning.thread.bankDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhiwen.qi
 * @description 银行类
 * @date 2019/11/17
 */
public class Bank {

    private final double[] accounts;

    //可重入锁
    private Lock bankLock;

    /*条件对象,目的是为了发现来源账户余额不足时，将转账的线程阻塞，并释放锁。
    *这样其他线程可以获取锁并进行转账操作，等到余额充足时，被阻塞的线程有机会再次竞争锁，如果获取到锁则可以再检查然后执行转账操作
    */
    private Condition sufficientFunds;

    /**
     * 银行类构造器
     * @param n 账户的数量
     * @param initialBalance 每个账户初始金额
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initialBalance;
        }
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    /**
     * 模拟转账
     * @param from 来源账户
     * @param to  目标账户
     * @param amount  转账金额
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            //调用getTotalBalance方法，bankLock锁对象的持有计数会增加1，变为2，方法执行完持有计数-1。
            System.out.printf(" Total Balance: %10.2f%n",getTotalBalance());
            sufficientFunds.signalAll();
        }finally {
            bankLock.unlock();
        }
    }

    /**
     * 获取总金额
     * @return  总金额
     */
    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    /**
     * 获取账户数
     * @return 账户数
     */
    public int size() {
        return accounts.length;
    }


}
