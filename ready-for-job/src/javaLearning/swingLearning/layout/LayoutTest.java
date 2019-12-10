package javaLearning.swingLearning.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/12/4
 */
public class LayoutTest {

    public static void main(String[] args) {
//        createFrame("流式布局测试",new LayoutTest().flowLayoutTest());
//        createFrame("网格布局测试",new LayoutTest().gridLayoutTest());
        createFrame("网格袋布局测试", new LayoutTest().gridBagTest());
    }

    public static void createFrame(String title,JPanel panel) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jf = new JFrame(title);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setLocationRelativeTo(null);
                jf.setContentPane(panel);
                jf.pack();
                jf.setVisible(true);
            }
        });

    }

    /**
     * 流式布局
     * @return 内容面板
     */
    public JPanel flowLayoutTest(){
        //创建内容面板，使用流式布局
        JPanel panel = new JPanel();
        FlowLayout layout = new FlowLayout(FlowLayout.RIGHT,10,20);
        panel.setLayout(layout);

        for (int i=0;i<5;i++) {
            JButton button = new JButton("按钮"+i);
            panel.add(button);
        }
        return panel;
    }

    /**
     * 网格布局
     * @return 内容面板
     */
    public JPanel gridLayoutTest(){
        GridLayout layout = new GridLayout(3,3,10,20);
        JPanel panel = new JPanel(layout);
        for (int i = 0; i < 8; i++) {
            JButton button = new JButton("按钮" + i);
            panel.add(button);
        }
        return panel;
    }

    /**
     * 网格袋布局
     * @return
     */
    public JPanel gridBagTest() {
        //网格袋布局管理器
        GridBagLayout gridBag = new GridBagLayout();
        //网格袋约束
        GridBagConstraints c = null;
        JPanel panel = new JPanel(gridBag);

        JButton btn01 = new JButton("按钮01");
        JButton btn02 = new JButton("按钮02");
        JButton btn03 = new JButton("按钮03");
        JButton btn04 = new JButton("按钮04");
        JButton btn05 = new JButton("按钮05");
        JButton btn06 = new JButton("按钮06");
        JButton btn07 = new JButton("按钮07");
        JButton btn08 = new JButton("按钮08");
        JButton btn09 = new JButton("按钮09");
        JButton btn10 = new JButton("按钮10");

        //添加按钮和约束到布局管理器

        //按钮01
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn01,c);

        //按钮02
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn02,c);

        //按钮03
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn03,c);

        //按钮04，显示区域占满当前行剩余空间(换行)，组件填充显示区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn04,c);

        //按钮05，显示区域独占一行（换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn05,c);

        //按钮06，显示区域占到当前行倒数第二个单元格（下一个组件后需要手动换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn06,c);

        //按钮07，放置在当前行最后一个单元格（换行）
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.addLayoutComponent(btn07,c);

        //按钮08，显示区域占两行，组件填充显示区域
        c = new GridBagConstraints();
        c.gridheight = 2;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn08,c);

        //按钮09，显示区域占满当前行剩余空间（换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridheight = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn09,c);

        //按钮10，显示区域占满当前行剩余空间（换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridheight = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn10,c);

        //添加组件到内容面板
        panel.add(btn01);
        panel.add(btn02);
        panel.add(btn03);
        panel.add(btn04);
        panel.add(btn05);
        panel.add(btn06);
        panel.add(btn07);
        panel.add(btn08);
        panel.add(btn09);
        panel.add(btn10);

        return panel;

    }


    /**
     * 箱式布局
     * @return 内容面板
     */
    public JPanel boxLayoutTest() {
        return new JPanel();
    }

}
