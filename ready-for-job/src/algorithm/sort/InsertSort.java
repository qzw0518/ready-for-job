package algorithm.sort;

import java.util.Arrays;

/**
 * @author zhiwen.qi
 * @description 插入排序。将数组分为有序和无序的两部分，每次使用无序部分的一个元素在有序部分中找位置并插入。
 * @date 2019/10/26
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = {9, 7, 5, 2, 4, 10};
        new InsertSort().insertSort(a);
        System.out.println(Arrays.toString(a));
    }


    public void insertSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        //变量i作为无序部分第一个元素的下标
        for (int i = 1; i < a.length; i++) {
            //变量j控制有序部分的比较循环
            for (int j = 0; j < i; j++) {
                //如果待比较元素小于有序的下标为j的元素，那么需要将下标为j的元素及之后的有序元素向后移动一个，然后将a[i]插入到j位置
                if (a[i] < a[j]) {
                    //先存储a[i]的值，后续需要从i开始将前一个元素值赋给后一个元素
                    int tmp = a[i];
                    //变量k控制元素的移动
                    for (int k = i; k > j ; k--) {
                        a[k] = a[k - 1];
                    }
                    //将a[i]插入到j位置
                    a[j] = tmp;
                }
            }
        }
    }

}
