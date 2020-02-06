package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiwen.qi
 * @description
 * 题目描述
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
 * 请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 * Input Param
 * n               输入随机数的个数
 * inputArray      n个随机整数组成的数组
 * Return Value
 * OutputArray    输出处理后的随机整数
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 * 输入描述:
 * 输入多行，先输入随机整数的个数，再输入相应个数的整数
 * 输出描述:
 * 返回多行，处理后的结果
 * 示例1
 * 输入
 * 3
 * 2
 * 2
 * 1
 * 11
 * 10
 * 20
 * 40
 * 32
 * 67
 * 40
 * 20
 * 89
 * 300
 * 400
 * 15
 * 输出
 * 1
 * 2
 * 10
 * 15
 * 20
 * 32
 * 40
 * 67
 * 89
 * 300
 * 400
 * @date 2020/2/5 19:04
 */
public class RandomNumberHandle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] result = new RandomNumberHandle().getResult(a);
            for (int j = 0; j < result.length; j++) {
                if (result[j] == 1) {
                    System.out.println(j);
                }
            }
        }
        sc.close();
    }

    public int[] getResult(int[] a) {
        //根据输入的数的特征1~1000设置大小为1001的数组。将随机数下标对应位置标1
        int[] result = new int[1001];
        for (int i = 0; i < a.length; i++) {
            result[a[i]] = 1;
        }
        return result;
    }
}