package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiwen.qi
 * @description
 * 题目描述
 * 描述：
 *
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 *
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入
 * 1516000
 * 输出
 * 0006151
 * @date 2020/2/6 16:39
 */
public class ReverseNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        System.out.println(new StringBuilder("" + num).reverse().toString());
    }

}
