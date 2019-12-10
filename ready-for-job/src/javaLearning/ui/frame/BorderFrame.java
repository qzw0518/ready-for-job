package javaLearning.ui.frame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/16
 */
public class BorderFrame extends JFrame {

    private JPanel demoPanel;

    private JPanel buttonPanel;

    private ButtonGroup buttonGroup;

    public BorderFrame() {
        demoPanel = new JPanel();
        buttonPanel = new JPanel();
        buttonGroup = new ButtonGroup();

        addRadioButton("Lower bevel",BorderFactory.createLoweredBevelBorder());
        addRadioButton("Raised bevel",BorderFactory.createRaisedBevelBorder());
        addRadioButton("Etched",BorderFactory.createEtchedBorder());
        addRadioButton("Line",BorderFactory.createLineBorder(Color.BLUE));
        addRadioButton("Matte",BorderFactory.createMatteBorder(10,10,10,10,Color.BLUE));
        addRadioButton("Empty",BorderFactory.createEmptyBorder());

        Border etchedBorder = BorderFactory.createEtchedBorder();
        Border titledBorder = BorderFactory.createTitledBorder(etchedBorder,"Border types");
        buttonPanel.setBorder(titledBorder);

        setLayout(new GridLayout(2,1));
        add(buttonPanel);
        add(demoPanel);
        pack();
    }


    private void addRadioButton(String name, final Border b) {
        JRadioButton button = new JRadioButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                demoPanel.setBorder(b);
            }
        });
        buttonGroup.add(button);
        buttonPanel.add(button);
    }
}
