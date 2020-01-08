package algorithm.sort;

import java.util.Arrays;

/**
 * @author zhiwen.qi
 * @description 快速排序
 * @date 2019/10/26
 */
public class QuickSort {
    public static void main(String[] args){
        int[] a = {7,3,2,1,4,6,5};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a, int left, int right) {
        if(left < right) {
            int i = left;   //左游标初始化
            int j = right;  //右游标初始化
            int x = a[i];  //x作为快排每一趟的标定值
            while (i < j){
                //从右往左找第一个小于X数，加i < j限制是因为内层循环一直在变化i和j，防止i超过j。
                while (i < j && a[j] > x) {
                    j--;
                }
                if (i < j){
                    a[i] = a[j];    //第一小于x的数挪到分界点
                    i++;
                }
                //从左向右找第一个比大于x的数,如果不加i < j限制。如果x为最大元素，此时会一直加到数组末尾并且再+1，超出数组范围
                while (i < j && a[i] < x){
                    i++;
                }
                if (i < j){
                    a[j] = a[i];    //第一个大于x的数挪到分界点
                    j--;
                }
            }
            //上述循环会导致数组中丢失标定值，所以要还原标定值
            a[i] = x;
            quickSort(a,left,i-1);
            quickSort(a,i+1,right);
        }
    }


}
