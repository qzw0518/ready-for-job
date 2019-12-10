package javaLearning.thread.blockQueue;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者-消费者模式应用-阻塞队列。当试图向队列添加元素而队列已满，或是想从队列移出元素而队列为空时，阻塞队列导致线程阻塞。
 * 工作者线程可以周期性地将中间结果存储在阻塞队列中，其他工作者线程移出中间结果并进一步修改。
 * 队列会自动地平衡负载。如果第一个线程集运行地比第二个慢，第二个线程集在等待结果时会阻塞；如果第一个快，将等第二个追赶上。
 * @author zhiwen.qi
 * @description 在一个目录及所有子目录下搜索文件，打印包含指定关键字的行。
 * @date 2019/11/20
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base directory (e.g. /usr/local/jdk1.8.152/src):");
        String directory = in.nextLine();
        System.out.print("Enter keyword (e.g. volatile): ");
        String keyword = in.nextLine();
        final int FILE_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 100;

        BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
        FileEnumerationTask enumerator = new FileEnumerationTask(queue,new File(directory));
        new Thread(enumerator).start();
        for (int i = 1;i <= SEARCH_THREADS;i++) {
            new Thread(new SearchTask(queue,keyword)).start();
        }
    }
}
