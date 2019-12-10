package javaLearning.ui.component;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/5
 */
public class Shape2DComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
        g2.draw(rect);

        Ellipse2D ellipse2D = new Ellipse2D.Double();
        ellipse2D.setFrame(rect);
        g2.draw(ellipse2D);

        g2.draw(new Line2D.Double(leftX,topY,leftX+width,topY+height));

        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX,centerY,centerX+radius,centerY+radius);
        g2.draw(circle);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }
}
