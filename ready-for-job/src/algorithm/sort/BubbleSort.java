package algorithm.sort;

import java.util.Arrays;

/**
 * @author zhiwen.qi
 * @description 冒泡排序
 * @date 2019/10/26
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] a = {30,40,60,10,20,50};
        bubbleSort(a);
        System.out.print(Arrays.toString(a));
    }


    public static void bubbleSort(int[] a){
        long start = System.currentTimeMillis();
        if (a == null || a.length == 0){
            return;
        }
        int temp = 0;
        for(int i = a.length;i > 0 ;i--){  //外层变量控制比较的数字范围，即在哪些下标范围内比较
            for(int j = 1; j < i ; j++){  //内层变量控制比较步骤，一步步向后推进
                if (a[j-1] > a[j]){
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("takes %d \n",end -start);
    }
}
