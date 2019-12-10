package javaLearning.ui.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/11
 */
public class ButtonFrame extends JFrame {

    private JPanel panel;

    public ButtonFrame() {
        setSize(300,200);
        //create buttons
        JButton yellow = new JButton("yellow");
        JButton red = new JButton("red");
        JButton blue = new JButton("blue");
        ButtonModel model = blue.getModel();

        panel = new JPanel();

        //add buttons to panel
        panel.add(yellow);
        panel.add(red);
        panel.add(blue);

        //add panel to frame
        add(panel);

        //create button listeners
        ColorActionListener yellowAction = new ColorActionListener(Color.YELLOW);
        ColorActionListener redAction = new ColorActionListener(Color.RED);
        ColorActionListener blueAction = new ColorActionListener(Color.BLUE);

        //associate button with listener
        yellow.addActionListener(yellowAction);
        red.addActionListener(redAction);
        blue.addActionListener(blueAction);
    }


    /**
     *事件处理基本用法。定义内部动作类实现ActionListener接口，覆写actionPerformed方法。
     */
    private class ColorActionListener implements ActionListener {

        private Color backgroundColor;

        public ColorActionListener(Color c) {
            backgroundColor = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(backgroundColor);

            /**
            //另一种做法是在Frame中直接实现ActionListener接口，然后通过判断事件源的方式来执行不同操作
            JButton eventSource_1 = new JButton();
            JButton eventSource_2 = new JButton();
            //judge event's source,
            if (e.getSource() == eventSource_1) {
                //do something
            }else if (e.getSource() == eventSource_2) {
                //do something
            }
            */
        }
    }



}
