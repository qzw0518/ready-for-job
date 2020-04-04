package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiwen.qi
 * @description
 * 题目描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 * 详细描述：
 * 函数接口说明：
 * public String getResult(long ulDataInput)
 * 输入参数：
 * long ulDataInput：输入的正整数
 * 返回值：
 * String
 * 输入描述:
 * 输入一个long型整数
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 * 示例1
 * 输入
 * 180
 * 输出
 * 2 2 3 3 5
 * @date 2020/2/6 13:17
 */
public class PrimeFactor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        sc.close();
        System.out.println(getPrimeFactor(num));
    }

    public static String getPrimeFactor(long number) {
        StringBuilder result = new StringBuilder();
        for (long i = 2; i <= number; i++) {
            if (number % i == 0) {
                result.append(i + " ");
                number = number / i;
                i = 1;
            }
        }
        return result.toString();
    }

}
