package javaLearning.thread.bankDemo;


/**
 * @author zhiwen.qi
 * @description 执行转账操作的线程
 * @date 2019/11/17
 */
public class TransferRunnable implements Runnable {

    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private final int DELAY = 10;

    /**
     * 构造器，传入一些参数
     * @param b  账户之间转账的银行
     * @param from  来源账户
     * @param max  最大转账金额
     */
    public TransferRunnable(Bank b, int from, double max) {
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int toAccount = (int) (bank.size() * Math.random());
                double amount = maxAmount * Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }
        }catch (InterruptedException e) {

        }
    }
}
