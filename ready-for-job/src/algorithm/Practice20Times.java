package algorithm;

import java.util.Arrays;

/**
 * @author zhiwen.qi
 * @description 孰能生巧
 * @date 2019/11/2
 */
public class Practice20Times {

    public static void main(String[] args) {
        int[] a = {9,6,4,12,5,7,9,1,10};
//        new Practice20Times().quickSort(a,0,a.length-1);
//        new Practice20Times().mergeSort(a,0,a.length-1);
//        new Practice20Times().bubbleSort(a);
//        System.out.println(Arrays.toString(a));
//        System.out.println(binarySearchNoRecursion(a, 6));
//        System.out.println(binarySearchRecursion(a, 6));
//        System.out.println(dynamicFibonacci(4));
        System.out.println(findIndexInFib(8));
    }

    /**
     * 快速排序
     * @param a 数组
     * @param l 起始下标
     * @param r 结束下标
     */
    public void quickSort(int[] a , int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int x = a[i];
            while (i < j && a[j] > x) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            while (i < j && a[i] < x) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
            a[i] = x;
            quickSort(a, l , i - 1);
            quickSort(a, i + 1, r);
        }
    }

    /**
     * 归并排序
     * @param a 数组
     * @param l 起始下标
     * @param r 结束下标
     */
    public void mergeSort(int[] a, int l, int r) {
        if (a == null || a.length == 0 || l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    /**
     * 归并排序归并过程
     * @param a 数组
     * @param l 第一个有序数组起始下标
     * @param mid 第一个有序数组结束下标
     * @param r 第二个有序数组结束下标
     */
    private void merge(int[] a, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int[] temp = new int[r - l + 1];
        int k = 0;
        while (i <= mid && j <= r) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= r) {
            temp[k++] = a[j++];
        }
        for (int m = 0; m < k; m++) {
            a[l + m] = temp[m];
        }
    }

    /**
     * 冒泡排序
     * @param a 数组
     */
    public static void bubbleSort(int[] a){
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }



    /**
     * 二分查找非递归方式
     * @param orderedArray 非降序数组
     * @param target 目标数
     * @return 目标数在数组中的下标，如果没有则返回-1
     */
    public static int binarySearchNoRecursion(int[] orderedArray, int target) {
        if (orderedArray == null || orderedArray.length == 0) {
            return -1;
        }
        if (orderedArray[0] > target || orderedArray[orderedArray.length - 1] < target) {
            return -1;
        }
        int left = 0;
        int right = orderedArray.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (orderedArray[mid] == target) {
                return mid;
            }
            if (orderedArray[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找递归方式
     * @param orderedArray 非降序数组
     * @param target 目标数
     * @return 目标数在数组中下标，如果没有则返回-1
     */
    public static int binarySearchRecursion(int[] orderedArray, int target) {
        if (orderedArray == null || orderedArray.length == 0) {
            return -1;
        }
        if (orderedArray[0] > target || orderedArray[orderedArray.length - 1] < target) {
            return -1;
        }
        return getResult(orderedArray, 0, orderedArray.length - 1, target);
    }

    /**
     * 二分查找递归函数
     * @param orderedArray 非降序数组
     * @param left 起始下标
     * @param right 结束下标
     * @param target 目标数
     * @return 目标书在数组中left~right范围内的下标，如果没有则返回-1
     */
    private static int getResult(int[] orderedArray, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (orderedArray[mid] == target) {
            return mid;
        }
        if (orderedArray[mid] > target) {
            return getResult(orderedArray, left , mid - 1, target);
        }else {
            return getResult(orderedArray, mid + 1, right, target);
        }
    }

    /**
     * 求斐波那契数列的指定位置的数。动态规划思想。1, 1, 2, 3, 5, ...
     * @param index 指定位置
     * @return 指定位置数。
     */
    public static int dynamicFibonacci(int index) {
        if (index < 0) {
            return -1;
        }
        if (index == 0 || index == 1) {
            return 1;
        }
        int result = 0;
        int fib1 = 1;
        int fib2 = 1;
        for (int i = 2; i <= index; i++) {
            result = fib1 + fib2;
            fib1 = fib2;
            fib2 = result;
        }
        return result;
    }

    /**
     * 找到目标数在斐波那契数列中的位置。1, 1, 2, 3, 5, ...
     * @param target 目标数
     * @return 目标数在斐波那契数列中的位置，如果不存在则返回-1
     */
    public static int findIndexInFib(int target) {
        if (target < 0) {
            return -1;
        }
        if (target == 1) {
            return 0;
        }
        int fib = 0;
        int fib1 = 1;
        int fib2 = 1;
        int index = 2;
        while (true) {
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
            if (target == fib) {
                return index;
            }
            if (target < fib) {
                break;
            }
            index++;
        }
        return -1;
    }

}
