package algorithm.sort;

import java.util.Arrays;

/**
 * @author zhiwen.qi
 * @description 堆排序。
 * 数组表示的堆的性质。a[i]的左节点为a[2i+1]，右节点为a[2i+2]。
 * 对于一个完全二叉树。第一个叶子节点索引为a.length / 2，最后一个非叶子节点索引为a.length / 2 - 1
 * 1.首先将无序序列构建成一个大顶堆数组。
 * 2.然后将堆顶元素移动到数组末端，堆大小减1并重新构建大顶堆
 * 3.重复2步骤直到堆大小为0
 * @date 2019/10/26
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {4, 5, 8, 2, 3, 9, 7, 1};
        HeapSort heapSort = new HeapSort();
//        heapSort.buildMaxHeap(a, a.length);
//        //交换完后堆数组应该为[9, 5, 8, 2, 3, 4, 7, 1]
//        System.out.println(Arrays.toString(a));
        heapSort.heapSort(a);
        System.out.println(Arrays.toString(a));
    }


    public void heapSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int len = a.length;
        //构建最大堆数组
        buildMaxHeap(a, len);
        //交换堆顶和当前末尾节点，并调整最大堆
        for (int i = len - 1; i > 0 ; i--) {
            swap(a, 0, i);
            //堆大小-1
            len--;
            //重新调整最大堆
            downAdjustMaxHeap(a, 0, len);
        }
    }


    /**
     * 构建最大堆
     * @param a 无序数组
     * @param len 堆大小
     */
    private void buildMaxHeap(int[] a, int len) {
        //从最后一个非叶子节点开始向前遍历，调整节点，使之称为最大堆
        for (int i = a.length / 2 - 1; i >= 0 ; i--) {
            downAdjustMaxHeap(a, i, len);
        }
    }


    /**
     * 向下调整最大堆
     * @param a 无序数组
     * @param i 起始位置。非叶子节点
     * @param len 堆大小
     */
    private void downAdjustMaxHeap(int[] a, int i, int len) {
        //左子节点索引
        int left = 2 * i + 1;
        //右子节点索引
        int right = 2 * i + 2;
        //默认当前节点(父节点)是最大值
        int largestIndex = i;
        //左子节点和较大节点比较
        if (left < len && a[left] > a[largestIndex]) {
            largestIndex = left;
        }
        //右子节点和较大节点比较
        if (right < len && a[right] > a[largestIndex]) {
            largestIndex = right;
        }
        if (largestIndex != i) {
            //如果最大值不是父节点，则需要交换父节点和较大子节点
            swap(a, i, largestIndex);
            //交换之后，子节点值变化了，如果子节点有自己的子节点，需要继续调整
            downAdjustMaxHeap(a, largestIndex, len);
        }

    }

    /**
     * 交换节点值
     * @param a 堆数组
     * @param i 任一节点
     * @param j 任一节点
     */
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
