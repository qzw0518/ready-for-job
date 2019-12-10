package javaLearning.ui.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/15
 */
public class TextFrame extends JFrame {

    private JTextField usernameField;

    private JPasswordField passwordField;

    private JTextArea textArea;

    public TextFrame() {
        //框架北部面板，使用边框布局
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        //北部面板中的北部内容
        JLabel headerLabel = new JLabel("请输入用户名和密码");
        headerLabel.setFont(new Font(null,0,16));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        northPanel.add(headerLabel,BorderLayout.NORTH);
        //北部面板中的中部面板,2行一列，第一行为用户名面板，第二行为密码面板
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2,2));
        inputPanel.add(new JLabel("Username: ", SwingConstants.CENTER));
        usernameField = new JTextField();
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Password: ", SwingConstants.CENTER));
        passwordField = new JPasswordField();
        inputPanel.add(passwordField);

        northPanel.add(inputPanel,BorderLayout.CENTER);
        //将北部面板加入到框架
        add(northPanel,BorderLayout.NORTH);

        //框架中部内容
        textArea = new JTextArea(8,20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane,BorderLayout.CENTER);

        JButton insertButton = new JButton("insert");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("User name: " + usernameField.getText() +
                        " Password: " + new String(passwordField.getPassword()) +
                        "\n");
            }
        });

        JPanel southPanel = new JPanel();
        southPanel.add(insertButton);

        add(southPanel,BorderLayout.SOUTH);

        pack();

    }
}
