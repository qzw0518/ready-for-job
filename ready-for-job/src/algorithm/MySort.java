package algorithm;

import java.util.Arrays;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/6
 */
public class MySort {

    public static void main(String[] args) {
        int[] k = {0,1,0,4,8,2};
        mySort(k);
        System.out.println(Arrays.toString(k));
    }

    public static void mySort(int[] k) {
        //临时数组，数组下标为0-9，对应0-9数字，值为数字出现的次数
        int[] tmp = new int[10];
        //遍历目标数组，获取其中不同数字出现次数
        for (int i = 0;i < k.length;i++) {
            tmp[k[i]] += 1;
        }
        //数字出现次数计数
        int count = 0;
        //目标数组重构控制下标
        int index = 0;
        //重构目标数组
        for (int j = 0;j < tmp.length;j++) {
            //判断数字是否出现
            if (tmp[j] != 0) {
                //记录数字出现次数
                count = tmp[j];
                //重构目标数组
                while (count > 0) {
                    k[index] = j;
                    index++;
                    count--;
                }
            }
        }
    }
}
