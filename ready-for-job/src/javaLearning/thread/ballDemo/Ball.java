package javaLearning.thread.ballDemo;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * @author zhiwen.qi
 * @description 模拟球
 * @date 2019/11/16
 */
public class Ball {
    private static final int XSZIE = 15;
    private static final int YSZIE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    /**
     * 球运动轨迹控制
     * 移动球到下一个位置，如果碰到边界则反向移动
     * @param bounds 球运动的长方形边界
     */
    public void move(Rectangle2D bounds) {
        x += dx;
        y += dy;
        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x + XSZIE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSZIE;
            dx = -dx;
        }
        if (y < bounds.getMinX()) {
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y + YSZIE >= bounds.getMaxY()) {
            y = bounds.getMaxY() - YSZIE;
            dy = -dy;
        }
    }

    /**
     * 在当前位置创建球形状
     * @return
     */
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x,y,XSZIE,YSZIE);
    }
}
