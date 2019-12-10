package javaLearning.ui.swingAndthread;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/20
 */
public class BadWorkerRunnable implements Runnable {

    private JComboBox<Integer> combo;
    private Random generator;

    public BadWorkerRunnable(JComboBox<Integer> combo) {
        this.combo = combo;
        generator = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int i = Math.abs(generator.nextInt());
                if (i % 2 == 0) {
                    combo.insertItemAt(i,0);
                }else if (combo.getItemCount() > 0) {
                    combo.removeItemAt(i % combo.getItemCount());
                }
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
