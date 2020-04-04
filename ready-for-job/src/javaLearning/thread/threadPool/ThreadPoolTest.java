package javaLearning.thread.threadPool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/20
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("------程序开始------");
        //记录程序开始时间
        Date d1 = new Date();
        int taskSize = 5;

        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);

        //创建有多个返回值的任务
        List<Future> resultList = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable(i + " ");

            //执行任务并获取返回结果
            Future f = pool.submit(c);
            resultList.add(f);
        }

        //关闭线程池
        pool.shutdown();

        for (Future f : resultList) {
            System.out.println("------result: " + f.get().toString());
        }

        Date d2 = new Date();
        System.out.println("------程序运行结束------程序耗时：" + (d2.getTime() - d1.getTime()) + "毫秒");
    }


}

class MyCallable implements Callable<Object> {

    //任务编号
    private String taskNum;

    public MyCallable (String taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "启动");
        //记录任务开始时间
        Date date1 = new Date();
        Thread.sleep(1000);

        //记录任务结束时间
        Date date2 = new Date();
        //计算任务耗时
        long time = date2.getTime() - date1.getTime();
        System.out.println(">>>" + taskNum + "结束");

        return taskNum + "任务返回运行结果，耗时" + time + "毫秒";
    }
}
