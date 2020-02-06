package algorithm.huawei;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhiwen.qi
 * @description
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 输入：
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 下面是一个简单的例子 如：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 处理过程：
 * 起点（0,0）
 * +   A10   =  （-10,0）
 * +   S20   =  (-10,-20)
 * +   W10  =  (-10,-10)
 * +   D30  =  (20,-10)
 * +   x    =  无效
 * +   A1A   =  无效
 * +   B10A11   =  无效
 * +  一个空 不影响
 * +   A10  =  (10,-10)
 * 结果 （10， -10）
 * 输入描述:
 * 一行字符串
 * 输出描述:
 * 最终坐标，以,分隔
 * 示例1
 * 输入
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 输出
 * 10,-10
 * @date 2020/2/5 11:29
 */
public class LocationCompute {

    public static void main(String[] args) {
        new LocationCompute().computeLocation("A10;S20;W10;D30;X;A1A;B10A11;;A10;");
    }

    /**
     * 计算并输出最后的位置坐标
     * @param src 指令字符串
     */
    public void computeLocation(String src) {
        if (src == null) {
            System.err.println("null string");
            return;
        }
        int x = 0;
        int y = 0;
        String[] movements = src.split(";");
        for (int i = 0; i < movements.length; i++) {
            if (isValidMovement(movements[i])) {
                int step = 0;
                step = Integer.valueOf(movements[i].substring(1));
                char direction = movements[i].charAt(0);
                switch (direction) {
                    case 'A':
                        x -= step;
                        break;
                    case 'D':
                        x += step;
                        break;
                    case 'W':
                        y += step;
                        break;
                    case 'S':
                        y -= step;
                        break;
                }
            }
        }
        System.out.println(x + "," + y);
    }


    /**
     * 检查字符串是否是有效的移动指令
     * @param movementString 移动指令字符串
     * @return 是否有效移动指令
     */
    private boolean isValidMovement(String movementString) {
        String regex = "^[ADWS][1-9][0-9]?$";
        Pattern movementPattern = Pattern.compile(regex);
        Matcher matcher = movementPattern.matcher(movementString);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

}
