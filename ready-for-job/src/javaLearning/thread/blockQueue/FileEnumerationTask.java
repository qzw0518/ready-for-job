package javaLearning.thread.blockQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhiwen.qi
 * @description 枚举文件任务线程
 * @date 2019/11/20
 */
public class FileEnumerationTask implements Runnable {

    //在队列中放置一个虚拟对象，当搜索线程搜索到这个虚拟对象，终止
    public static File DUMMY = new File("");

    private BlockingQueue<File> queue;
    private File startingDirectory;

    /**
     * 构建一个枚举文件的任务
     * @param queue 枚举的文件被加入的阻塞队列
     * @param startingDirectory 枚举起始目录
     */
    public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory) {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    @Override
    public void run() {
        try {
            enumerate(startingDirectory);
            queue.put(DUMMY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归方式枚举文件并加入队列
     * @param directory 枚举的文件夹
     * @throws InterruptedException 线程中断异常
     */
    public void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                enumerate(file);
            }else {
                queue.put(file);
            }
        }
    }
}
