package javaLearning.ui;

import javaLearning.ui.adapter.Terminator;
import javaLearning.ui.frame.*;
import javaLearning.ui.layout.CalculatorPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/5
 */
public class MainUI {
    public static void main(String[] args) {
//        frameAndComponent();
//        actionListener();
//        changePlatSytle();
//        inputAndAction();
        calculator();
//        textFrame();
//        checkFrame();
//        radioFrame();
//        borderFrame();
    }

    /**
     * UI基础
     * 开一个线程用来制作界面。先绘制框架Frame,然后填充Component。
     * JPanel继承JComponent继承Container继承Component，JFrame继承Frame继承Window继承Container继承Component。
     */
    public static void frameAndComponent() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //自定义的Frame可以继承JFrame并覆写其中一些方法
//                SimpleFrame frame = new SimpleFrame();
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setVisible(true);
                JFrame frame = new JFrame();
                frame.setSize(600,600);
                frame.setLocation(800,300);
                JPanel panel = new JPanel();
                panel.setToolTipText("this is panel");
                frame.add(panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }


    /**
     * 为组件设置事件监听
     */
    public static void actionListener() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ButtonFrame buttonFrame = new ButtonFrame();
                buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                buttonFrame.setVisible(true);
            }
        });
    }


    /**
     * 更换ui风格。
     * 加入窗口关闭的事件监听
     */
    public static void changePlatSytle() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PlatFrame platFrame = new PlatFrame();
                platFrame.addWindowListener(new Terminator());
                platFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                platFrame.setVisible(true);
            }
        });
    }


    /**
     * 输入映射与动作映射。（快捷键与动作绑定）
     */
    public static void inputAndAction() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ActionFrame actionFrame = new ActionFrame();
                actionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                actionFrame.setVisible(true);
            }
        });
    }

    /**
     * 计算器，使用网格布局
     */
    public static void calculator() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setTitle("calculator");
                frame.add(new CalculatorPanel());
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    /**
     * 文本框
     */
    public static void textFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new TextFrame();
                frame.setTitle("textFrame");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    /**
     * 复选框
     */
    public static void checkFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new CheckBoxFrame();
                frame.setTitle("checkFrame");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    /**
     * 单选按钮
     */
    public static void radioFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new RadioButtonFrame();
                frame.setTitle("radioFrame");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    /**
     * 边框线
     */
    public static void borderFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BorderFrame();
                frame.setTitle("borderFrame");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
