package javaLearning.ui.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/12
 */
public class ActionFrame extends JFrame {

    private JPanel buttonPanel;

    public ActionFrame() {
        setSize(300,200);
        buttonPanel = new JPanel();

        //定义动作
        Action yellowAction = new ColorAction("YELLOW",new ImageIcon("E:/icons/点赞.png"),Color.YELLOW);
        Action blueAction = new ColorAction("BLUE",new ImageIcon("E:/icons/点赞.png"),Color.BLUE);
        Action redAction = new ColorAction("RED",new ImageIcon("E:/icons/点赞.png"),Color.RED);

        //面板中加入按钮并为按钮绑定动作
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        //将面板加入到框架中
        add(buttonPanel);

        //定义输入映射并设置输入映射条件。此处设置为从具有输入焦点组件开始向父组件检查，如果设定的键存在就执行动作；如果动作已启用，停止
        InputMap inputMap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        //设置按键的键/值对。key对应快捷键，value需要作为ActionMap的key
        inputMap.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
        inputMap.put(KeyStroke.getKeyStroke("ctrl B"),"panel.blue");
        inputMap.put(KeyStroke.getKeyStroke("ctrl R"),"panel.red");

        //定义动作映射
        ActionMap actionMap = buttonPanel.getActionMap();
        //关联输入映射与动作
        actionMap.put("panel.yellow",yellowAction);
        actionMap.put("panel.blue",blueAction);
        actionMap.put("panel.red",redAction);

    }

    private class ColorAction extends AbstractAction {

        public ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME,name);
            putValue(Action.SMALL_ICON,icon);
            putValue(Action.SHORT_DESCRIPTION,"set panel color to " + name.toLowerCase());
            putValue("color",c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = (Color) getValue("color");
            buttonPanel.setBackground(color);
        }
    }
}
