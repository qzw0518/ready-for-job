package javaLearning.ui.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/16
 */
public class CheckBoxFrame extends JFrame {

    private JLabel label;

    public CheckBoxFrame() {
        setSize(300,200);
        setLocation(300,200);
        label = new JLabel();
        label.setText("this is a sentence to test checkbox");
        JCheckBox bold = new JCheckBox("Bold");
        JCheckBox italic = new JCheckBox("Italic");
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mode = 0;
                if (bold.isSelected()) {
                    mode += Font.BOLD;
                }
                if (italic.isSelected()) {
                    mode += Font.ITALIC;
                }
                label.setFont(new Font("Serial",mode,15));
            }
        };
        bold.addActionListener(actionListener);
        italic.addActionListener(actionListener);
        JPanel panel = new JPanel();
        panel.add(label,BorderLayout.CENTER);
        JPanel southPanel = new JPanel();
        southPanel.add(bold,BorderLayout.SOUTH);
        southPanel.add(italic,BorderLayout.SOUTH);
        panel.add(southPanel,BorderLayout.SOUTH);

        add(panel);
    }

}
