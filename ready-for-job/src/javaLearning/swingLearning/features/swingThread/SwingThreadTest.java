package javaLearning.swingLearning.features.swingThread;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/12/5
 */
public class SwingThreadTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                createGUI();
                createGUI2();
            }
        });
    }


    /**
     * SwingWorker简单应用
     */
    public static void createGUI() {
        JFrame jf = new JFrame("线程测试窗口");
        jf.setSize(300,300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        final JLabel label = new JLabel();
        label.setText("正在计算");
        panel.add(label);

        jf.setContentPane(panel);
        jf.setVisible(true);

        //创建后台任务
        SwingWorker<String,Object> task = new SwingWorker<String, Object>() {
            @Override
            protected String doInBackground() throws Exception {
                //此处处于SwingWorker线程池中
                //延时5s,模拟耗时操作
                Thread.sleep(5000);
                //返回计算结果
                return "Hello";
            }

            @Override
            protected void done() {
                //此方法将在后台任务完成后再事件调度线程(EventQueue)中被回调
                String result = null;
                try {
                    //获取计算结果
                    result = get();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                label.setText("计算结果" + result);
            }
        };

        //启动任务
        task.execute();
    }

    /**
     * SwingWorker线程间通信
     */
    public static void createGUI2() {
        JFrame jf = new JFrame("SwingWorker多线程通信测试窗口");
        jf.setSize(300,300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        final JLabel label = new JLabel("正在下载：0%");
        panel.add(label, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea();
        panel.add(textArea,BorderLayout.CENTER);

        jf.setContentPane(panel);
        jf.setVisible(true);

        //创建后台任务
        SwingWorker<String,Integer> task = new SwingWorker<String, Integer>() {
            @Override
            protected String doInBackground() throws Exception {
                for (int i = 0; i < 100; i += 10) {
                    //模拟延时操作
                    Thread.sleep(1000);

                    //设置progress属性的值(通过属性改变监听器传递数据到事件调度线程)
                    setProgress(i);

                    //通过SwingWorker内部机制传递数据到事件调度线程
                    publish(i);
                }
                //返回计算结果
                return "下载完成";
            }

            @Override
            protected void process(List<Integer> chunks) {
                //此方法在调用doInBackground调用publish方法后在事件调度线程中被回调
                Integer progressValue = chunks.get(0);
                textArea.append("已下载：" + progressValue + "%\n");
            }

            @Override
            protected void done() {
                //此方法在后台任务完成后在事件线程中被回调
                String result = null;

                try {
                    //获取计算结果
                    result = get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                label.setText(result);
                textArea.append(result);
            }
        };

        //添加属性改变监听器
        task.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("progress".equals(evt.getPropertyName())) {
                    Object progressValue = evt.getNewValue();
                    label.setText("正在下载：" + progressValue + "%");
                }
            }
        });

        //启动任务
        task.execute();
    }
}
