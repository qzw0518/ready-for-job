package algorithm.search;

/**
 * @author zhiwen.qi
 * @description 二分查找
 * @date 2019/11/4
 */
public class BinarySearch {

    /**
     * 二分查找递归方式主函数
     * @param a
     * @param target
     * @return
     */
    public int binarySearch(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        if (target < a[0] || target > a[a.length-1]) {
            return -1;
        }
        int mid = a.length/2;
        return getResult(a,0,mid,target);
    }

    /**
     * 二分查找递归函数
     * @param a 数组
     * @param left  左边界
     * @param right 有边界
     * @param target 目标数
     * @return 目标数在数组中下标，若没有返回-1
     */
    private int getResult(int[] a, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (a[mid] == target) {
            return mid;
        }
        if (a[mid] > target) {
            return getResult(a,left,mid-1,target);
        }
        if (a[mid] < target) {
            return getResult(a,mid+1,right,target);
        }
        return -1;
    }

    /**
     * 二分查找非递归方式
     * @param a 数组
     * @param target 目标数
     * @return 目标数在数组中下标，若不存在返回-1
     */
    public int getTarget(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        if (target < a[0] || target > a[a.length-1]) {
            return -1;
        }
        int low = 0;
        int high = a.length-1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
