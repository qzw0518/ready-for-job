package javaLearning.swingLearning.features.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/12/4
 */
public class ListenerTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                createFrame(new ListenerTest().actionListener());
                createFrame(new ListenerTest().focusListener());
            }
        });
    }

    public static void createFrame(JPanel panel) {
        JFrame frame = new JFrame("监听测试");
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * 动作监听器
     */
    public JPanel actionListener() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("按下按钮");
        panel.add(label, BorderLayout.NORTH);

        final String COMMAND_OK = "OK";
        final String COMMAND__CANCEL = "CANCEL";


        JButton btnOK = new JButton("确定");
        btnOK.setActionCommand(COMMAND_OK);

        JButton btnCancel = new JButton("取消");
        btnCancel.setActionCommand(COMMAND__CANCEL);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取事件源，即触发事件的组件(按钮)本身
//                e.getSource();

                //获取动作命令
                String command = e.getActionCommand();
                if (COMMAND_OK.equals(command)) {
                    label.setText("确定被点击");
                }else if (COMMAND__CANCEL.equals(e.getActionCommand())) {
                    label.setText("取消按钮被点击");
                }
            }
        };
        btnOK.addActionListener(listener);
        btnCancel.addActionListener(listener);

        panel.add(btnOK,BorderLayout.WEST);
        panel.add(btnCancel,BorderLayout.EAST);

        return panel;
    }

    /**
     * 焦点监听器
     */
    public JPanel focusListener() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("文本");
        panel.add(label);
        JButton btn = new JButton("确定");
        btn.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                label.setText("按钮获得焦点");
            }

            @Override
            public void focusLost(FocusEvent e) {
                label.setText("按钮失去焦点");
            }
        });

        JTextField textField = new JTextField(10);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                label.setText("文本框获得焦点");
            }

            @Override
            public void focusLost(FocusEvent e) {
                label.setText("文本框失去焦点");
            }
        });

        panel.add(btn);
        panel.add(textField);
        return panel;
    }




}
