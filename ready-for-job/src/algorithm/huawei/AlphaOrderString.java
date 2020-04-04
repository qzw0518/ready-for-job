package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiwen.qi
 * @description 牛客网测试用例有问题R难道不应该在Rid...前面吗？
 * 题目描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述:
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述:
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 * 输入
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 输出
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 * @date 2020/2/6 17:35
 */
public class AlphaOrderString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] ss = new String[size];
        for (int i = 0; i < size; i++) {
            ss[i] = sc.nextLine();
        }
        sc.close();
        quickSortString(ss, 0, ss.length - 1);
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }


    private static boolean s1Aheads2(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return false;
        }
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return true;
            }
            if (s1.charAt(i) > s2.charAt(i)) {
                return false;
            }
        }
        return false;
    }

    private static void quickSortString(String[] ss, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            String x = ss[i];
            while (i < j) {
                while (i < j && s1Aheads2(x, ss[j])) {
                    j--;
                }
                if (i < j) {
                    ss[i] = ss[j];
                    i++;
                }
                while (i < j && s1Aheads2(ss[i], x)) {
                    i++;
                }
                if (i < j) {
                    ss[j] = ss[i];
                    j--;
                }
                ss[i] = x;
                quickSortString(ss, left, i - 1);
                quickSortString(ss, i + 1 ,right);
            }
        }
    }




}
