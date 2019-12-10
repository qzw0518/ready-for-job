package javaLearning.thread.ballDemo;

import javax.swing.*;
import java.awt.*;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/16
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
