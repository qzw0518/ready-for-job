package javaLearning.thread;

/**
 * @author zhiwen.qi
 * @description 死锁的例子
 * 死锁条件：
 * 1.互斥。某个资源一段时间内只能被一个进程占有。
 * 2.不可抢占。资源被占有时无法被其他进程抢夺。
 * 3.占有且申请。形象的解释就是。吃着碗里的，看着锅里的。
 * 4.循环等待。进程间等待被占有资源，形成了等待环。
 * @date 2019/10/27
 */
public class DeadLockDemo {
    private static String A="A";
    private static String B="B";
    public static void main(String[] args){
        new DeadLockDemo().deadLock();
    }
    private void deadLock(){
        Thread threadA=new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(A){
                    try {
                        Thread.currentThread().sleep(2000);  //睡两秒确保了阻塞，不然可能直接运行下去了
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(B){
                        System.out.println("AB");
                    }
                }
            }
        });
        Thread threadB=new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(B){
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(A){
                        System.out.println("BA");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}

