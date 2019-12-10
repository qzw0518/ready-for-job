package javaLearning.ui.frame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/16
 */
public class RadioButtonFrame extends JFrame {

    private JLabel label;

    private JPanel panel;

    private ButtonGroup buttonGroup;

    private static final int DEFAULT_FONT_SZIE = 36;

    public RadioButtonFrame() {

        label = new JLabel("this is a text for testing radioGroup");
        label.setFont(new Font("Consolas",Font.PLAIN,DEFAULT_FONT_SZIE));
        add(label,BorderLayout.CENTER);

        panel = new JPanel();
        buttonGroup = new ButtonGroup();

        addRadioButton("Small",8);
        addRadioButton("Medium",12);
        addRadioButton("Large",18);
        addRadioButton("Extra Large",36);

        add(panel,BorderLayout.SOUTH);

        pack();
    }

    private void addRadioButton(String name, final int size) {
        boolean selected = size == DEFAULT_FONT_SZIE;
        JRadioButton button = new JRadioButton(name,selected);
        buttonGroup.add(button);
        panel.add(button);

        ActionListener listener = e -> label.setFont(new Font("Consolas",Font.PLAIN,size));

        button.addActionListener(listener);
    }
}
