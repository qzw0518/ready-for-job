package javaLearning.ui.adapter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author zhiwen.qi
 * @description  自定义窗口事件监听器
 * @date 2019/11/11
 */
public class Terminator extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("window is closing");
        super.windowClosing(e);
    }
}
