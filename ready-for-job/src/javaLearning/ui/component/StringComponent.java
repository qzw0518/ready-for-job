package javaLearning.ui.component;

import javax.swing.*;
import java.awt.*;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/5
 */
public class StringComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Hei,Swing!",600,400);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,400);
    }
}
