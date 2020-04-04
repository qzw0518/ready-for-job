package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiwen.qi
 * @description
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 *
 * 输出描述:
 * 输出到长度为8的新字符串数组
 *
 * 示例1
 * 输入
 * abc
 * 123456789
 * 输出
 * abc00000
 * 12345678
 * 90000000
 * @date 2020/2/5 19:48
 */
public class ReformStringArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReformStringArray rfs = new ReformStringArray();
        String first = rfs.handleString(sc.nextLine());
        String second = rfs.handleString(sc.nextLine());
        sc.close();
        String total = first + second;
        for (int i = 0; i < total.length(); i+=8) {
            System.out.println(total.substring(i,i+8));
        }
    }

    public String handleString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int zeroCount = 8 - (s.length() % 8);
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < zeroCount; i++) {
            builder.append('0');
        }
        return builder.toString();
    }

}
