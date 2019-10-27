package algorithm.sort;

import java.util.Arrays;

/**
 * @author zhiwen.qi
 * @description 归并排序
 * @date 2019/10/26
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {3,1,2,4,6,5};
        mergeSortUptoDown(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }


    /**
     * 将两个有序数组合并
     * @param a 整个数组
     * @param start 第一个有序数组的开始下标
     * @param mid 第一个有序数组的结束下标，也是第二个有序数组的开始
     * @param end 第二个有序数组的结束下标
     */
    public static void merge(int[] a, int start, int mid, int end) {
        //tmp是汇总两个有序区的临时区域
        int[] tmp = new int[end-start+1];
        //第一个有序区索引
        int i = start;
        //第二个有序区索引
        int j = mid + 1;
        //汇总区索引
        int k = 0;

        //比较两个有序区元素，按次序加入到汇总区
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                tmp[k] = a[i];
                k++;
                i++;
            }else {
                tmp[k] = a[j];
                k++;
                j++;
            }
        }

        //第二个有序区先遍历完，将第一个有序区剩余元素加到汇总区
        while (i <= mid) {
            tmp[k] = a[i];
            k++;
            i++;
        }

        //第一个有序区先遍历完，将第二个有序区剩余元素加到汇总区
        while (j <= end) {
            tmp[k] = a[j];
            k++;
            j++;
        }

        //将汇总后的元素，全部整合到数组a中
        for (int m = 0; m < k; m++) {
            a[start+m] = tmp[m];
        }
        tmp = null;
    }

    /**
     * 从上到下归并，即先假设大数组有序，
     * @param a
     * @param start
     * @param end
     */
    public static void mergeSortUptoDown(int[] a, int start, int end) {
        if (a == null || start >= end) {
            return;
        }
        int mid = (start + end)/2;
        //递归第一个有序区域
        mergeSortUptoDown(a,start,mid);
        //递归第二个有序区域
        mergeSortUptoDown(a,mid+1,end);
        //合并两个有序区域
        merge(a,start,mid,end);
    }
}
