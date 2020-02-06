package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiwen.qi
 * @description
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 *
 * 示例1
 * 输入
 * 0xA
 * 输出
 * 10
 * @date 2020/2/5 20:18
 */
public class HexToTen {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hexString = sc.nextLine();
        sc.close();
        new HexToTen().hexToTen(hexString);
    }

    public void hexToTen(String hexString) {
        hexString = hexString.substring(2,hexString.length());
        System.out.println(Long.parseLong(hexString, 16));
    }
}
