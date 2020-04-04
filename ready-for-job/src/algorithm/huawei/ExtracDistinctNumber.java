package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiwen.qi
 * @description
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入
 * 9876673
 * 输出
 * 37689
 * @date 2020/2/6 15:31
 */
public class ExtracDistinctNumber {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        getDistinctNumber(num);
    }


    public static void getDistinctNumber(int number) {
        if(number == 0){
            System.out.println(number);
            return;
        }
        //记录数字是否出现过的数组，出现过就标1
        int[] hasOccured = new int[10];
        //记录0-9数字出现顺序的数组，下标越小出现越早
        int[] numOrder = new int[10];
        for (int i = 0; i < numOrder.length; i++) {
            //这里初始化为10，是因为0也要记录，如果使用默认的0，将无法记录0出现的顺序
            numOrder[i] = 10;
        }
        //这里是为了去除末尾连续为0的情况，这时候末尾的0不应该记录
        while (number % 10 == 0) {
            number = number / 10;
        }
        int mod = 0;
        int i = 0;
        while (number != 0) {
            mod = number % 10;
            number = number / 10;
            if (hasOccured[mod] != 1) {
                hasOccured[mod] = 1;
                numOrder[i++] = mod;
            }
        }

        for (int j = 0; j < numOrder.length; j++) {
            if (numOrder[j] != 10) {
                System.out.print(numOrder[j]);
            }
        }

    }
}
