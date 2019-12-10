package javaLearning.ui.frame;

import javaLearning.ui.component.Shape2DComponent;
import javaLearning.ui.component.StringComponent;

import javax.swing.*;
import java.awt.*;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/5
 */
public class SimpleFrame extends JFrame {

    public SimpleFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);
        Image img = new ImageIcon("E:/icons/点赞.png").getImage();
        setIconImage(img);
        setTitle("这个是Frame标题");
        add(new Shape2DComponent());
        //后一个component会覆盖掉前一个
//        add(new StringComponent());
//        pack();
    }
}
