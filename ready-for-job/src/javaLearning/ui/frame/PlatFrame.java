package javaLearning.ui.frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/11
 */
public class PlatFrame extends JFrame {

    private JPanel panel;

    public PlatFrame() {
        panel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(),info.getClassName());
        }
        add(panel);
        pack();
    }

    private void makeButton(String name, final String platName) {
        JButton button = new JButton(name);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel(platName);
                    SwingUtilities.updateComponentTreeUI(PlatFrame.this);
                    pack();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
