package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiwen.qi
 * @description
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
 *
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 * 示例1
 * 输入
 * abc
 * 输出
 * 3
 * @date 2020/2/6 16:27
 */
public class CountDistinctChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(countDistinctChar(s));

    }

    public static int countDistinctChar(String s) {
        if (s== null || s.length() == 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int[] hasOccured = new int[128];

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 0 && cs[i] <= 127) {
                hasOccured[cs[i]] = 1;
            }
        }

        int count = 0;
        for (int j = 0; j < hasOccured.length; j++) {
            if (hasOccured[j] == 1) {
                count++;
            }
        }
        return count;
    }

}
