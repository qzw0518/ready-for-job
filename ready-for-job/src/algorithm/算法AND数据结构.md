[基础算法github链接](https://github.com/kdn251/interviews)

[LeetCode中文网](https://leetcode-cn.com/)

[牛客网](https://www.nowcoder.com)

[toc]
# 排序算法

![复杂度汇总](https://images2015.cnblogs.com/blog/975503/201702/975503-20170214211234550-1109833343.png)

## 快速排序
```java
package algorithm.sort;

import java.util.Arrays;

/**
 * @author zhiwen.qi
 * @description 快速排序
 * @date 2019/10/26
 */
public class QuickSort {
    public static void main(String[] args){
        int[] a = {3,2,1,4,6,5};
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

```

## 归并排序
```java
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

```

## 插入排序
```java
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

```

## 堆排序
```java
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

```

# 查找算法
## 二分查找
```java
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
        int low = 0;
        int high = a.length-1;
        int mid = 0;
        if (target < a[0] || target > a[a.length-1]) {
            return -1;
        }
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
```

# 链表
## 单向链表
### 反转单向链表
```java
package algorithm.datastructure.linkedList;

/**
 * @author zhiwen.qi
 * @description 反转单向链表
 * @date 2020/2/24 9:23
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        //初始化单向链表
        SinglyLinkedListNode head = new SinglyLinkedListNode(0);
        SinglyLinkedListNode pointer = head;
        for (int i = 1; i < 6; i++) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(i);
            pointer.next = node;
            pointer = pointer.next;
        }
        pointer = head;
        printList(pointer);
        //反转链表
        SinglyLinkedListNode reversedHead = reverse(head);
        pointer = reversedHead;
        printList(pointer);
    }

    /**
     * 反转单向链表
     * @param head 链表头节点
     * @return 反转后的链表头节点
     */
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode pre = null;
        SinglyLinkedListNode latter = null;
        while (head != null) {
            latter = head.next;
            head.next = pre;
            pre = head;
            head = latter;
        }
        return pre;
    }

    public static void printList(SinglyLinkedListNode pointer) {
        while (pointer != null) {
            System.out.print(pointer.val + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

}

```

# 树
## 二叉树
### 二叉树遍历
```java
package datastructure.tree;

import datastructure.TreeNode;

/**
 * @author zhiwen.qi
 * @description 二叉树遍历
 * @date 2019/11/3
 */
public class PrintTree {
    
    //前序遍历
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    //后续遍历
    public void backOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        backOrder(node.left);
        backOrder(node.right);
        System.out.println(node.val);
    }
}
```


# 算法思想
### 动态规划
#### 钢条切割问题
```java
package algorithm.thoughts.dynamic_programing;


/**
 * @author zhiwen.qi
 * @description 钢条切割问题
 * 给定一个长度为n英寸的钢条和价格表Pi(长度为i时钢条的价值)。切割长度为整数,求切割方案(可不切)
 * ————————————————————————————————————
 * 长度i  1  2  3  4  5  6  7  8  9  10
 * 价格Pi 1  5  8  9  10 17 17 20 24 30
 * ————————————————————————————————————
 * 对于n=4，分割4 = 2 + 2时有最大价值10
 * @date 2020/2/21 10:55
 */
public class HowToCut {

    public static void main(String[] args) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(cutRod(p, 4));
        System.out.println(memoCutRod(p, 4));
        System.out.println(bottomUpCutRod(p, 4));

        int n = 4;
        //记录长度为l时的最大价值
        int[] r = new int[n + 1];
        //记录长度为l时，切割出最大价值时的第一段长度
        int[] s = new int[n + 1];
        extendBottomUpCutRod(p, n, r, s);
        System.out.print("max val is: " + r[4] + " ,");
        System.out.print("the first len of divisions are: ");
        while (n > 0) {
            System.out.print(s[n] + " ");
            n = n - s[n];
        }
    }

    //对于长度为n的钢条其最大收益，有Rn = max(Pi + Rn - i)  (1<=i<=n)

    /**
     * 自顶向下递归求最大收益。当n逐渐变大会越来越慢，因为递归过程进行了重复计算。
     * 如n=4时，计算了cutRod(p, n - (1 ~ 3))，n = 3时计算了cutRod(p, n - (1 ~ 2))。二者都包含1~2的计算。
     * @param p 价格数组
     * @param n 钢条长度
     */
    public static int cutRod(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        int r = Integer.MIN_VALUE;
        for (int i = 1; i <= n ; i++) {
            r = Math.max(r, p[i - 1] + cutRod(p, n - i));   //p{i - 1}，注意下标从0开始p[0]对应P1
        }
        return r;
    }

    /**
     * 带备忘录的自顶向下递归
     * @param p 价值数组
     * @param n 长度
     * @return 长度为n的钢条切割的最大价值
     */
    public static int memoCutRod(int[] p, int n) {
        //长度为数组下标时的最大收益记录备忘录数组
        int[] r = new int[n + 1];
        for (int i = 0; i <= n ; i++) {
            r[i] = Integer.MIN_VALUE;
        }
        return memoCutRodAux(p, n, r);
    }

    /**
     * 计算长度为n时的最大价值
     * @param p 价值数组
     * @param n 长度
     * @param r 最大价值备忘录数组
     * @return
     */
    private static int memoCutRodAux(int[] p, int n, int[] r) {
        //先检查长度为n时最大价值是否已知，如果计算过则直接返回
        if (r[n] >= 0) {
            return r[n];
        }
        if (n == 0) {
            return 0;
        }else {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, p[i - 1] + memoCutRodAux(p, n - i, r));
            }
            r[n] = q;
            return q;
        }
    }

    /**
     * 自底向上递归计算长度为n时的最大价值
     * @param p 价值数组
     * @param n 长度
     * @return 钢条切割的最大价值
     */
    public static int bottomUpCutRod(int[] p, int n) {
        //记录长度为l时的最大价值
        int[] r = new int[n + 1];
        r[0] = 0;
        //求解规模为j的子问题最优解
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                //现在计算不需要递归，因为规模为j的子问题的所有子问题已经计算过最优解并存储
                q = Math.max(q, p[i - 1] + r[j - i]);
            }
            //规模为j的子问题最优解存入数组
            r[j] = q;
        }
        return r[n];
    }

    /**
     * 带切割位置记录的解法
     * @param p 价值数组
     * @param n 长度
     * @param r 最大价值数组
     * @param s 各个长度下最大价值切割出的第一段的长度
     */
    public static void extendBottomUpCutRod(int[] p, int n, int[] r, int[] s) {
        r[0] = 0;
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                if (q < p[i - 1] + r[j - i]) {
                    q = p[i - 1] + r[j - i];
                    s[j] = i;
                }
            }
            r[j] = q;
        }
    }

}

```
#### 背包问题



# 剑指offer刷题
### 二叉树变种遍历
```java
package algorithm.swordToOffer;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiwen.qi
 * @description 二叉树的一些遍历操作
 * @date 2019/10/29
 */
public class PrintBinaryTree {

    private static int level = 0;
    private static int k = 2;

    /**
     * 使用队列，依次从左至右层次遍历二叉树。
     * @param root 根节点
     */
    public void queuePrintTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                System.out.println(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }
    
    /**
     *输出二叉树第n层节点，需要外部辅助变量level
     * @param node 节点
     * @param n 第n层
     */
    public void printByLevel(TreeNode node, int n) {
        //初始层次为0，每次调用层次+1
        level++;
        if (node != null) {
            if (level == n) {
                System.out.print(node.val + "-");
            }
            printByLevel(node.left,n);
            printByLevel(node.right,n);
        }
        //回溯
        level--;
    }

    /**
     * 查找二叉排序树第k个节点，外部辅助变量k
     * @param root 二叉排序树根节点
     * @return 第k个节点
     */
    public TreeNode KthNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        KthNode(root.left);
        if (k == 0) {
            System.out.println(root.val);
        }
        k--;
        KthNode(root.right);
        return root;
    }
}
```

### 重建二叉树
```java
package algorithm.datastructure.tree;

/**
 * @author zhiwen.qi
 * @description 重建二叉树(不含重复元素)。中序+后序，中序+前序。必须要有中序才能确定相对位置
 * 例子：
 *          7
 *      6       5
 *   3     1  2    9
 * 10             8
 * 中序[10, 3, 6, 1, 7, 2, 5, 8, 9]
 * 后序[10, 3, 1, 6, 2, 8, 9, 5, 7]
 * 前序[7, 6, 3, 10, 1, 5, 2, 9, 8]
 * @date 2020/2/16 11:12
 */
public class RebuildBinaryTree {
    public static void main(String[] args) {
        int[] in = {10, 3, 6, 1, 7, 2, 5, 8, 9};
        int[] back = {10, 3, 1, 6, 2, 8, 9, 5, 7};
        int[] pre = {7, 6, 3, 10, 1, 5, 2, 9, 8};
//        TreeNode root = rebuildByInAndPre(pre, 0, pre.length - 1, in, 0, in.length - 1);
        TreeNode root = rebuildByInAndBack(back, 0 ,back.length - 1, in, 0, in.length - 1);
        System.out.println(root.right.left.val);
    }

    /**
     * 根据前序和中序重建二叉树
     * @param pre 前序序列
     * @param startPre 需要构建的子树在前序中的开始位置
     * @param endPre 需要构建的子树在前序序列的结束位置
     * @param in 中序序列
     * @param startIn 需要构建的子树在中序序列的开始位置
     * @param endIn 需要构建的子树在中序序列的结束位置
     * @return 构建的子树
     */
    public static TreeNode rebuildByInAndPre(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = rebuildByInAndPre(pre, startPre + 1, startPre + i - startIn,
                                               in, startIn, i - 1);     //i - startIn左子树元素个数
                root.right = rebuildByInAndPre(pre, endPre - (endIn - i) + 1, endPre,
                                                in, i + 1, endIn);      //endIn - i右子树元素个数
                break;
            }
        }
        return root;
    }

    /**
     * 根据后序和中序重建二叉树
     * @param back 后序序列
     * @param startBack 需要构建的子树在后序中的开始位置
     * @param endBack 需要构建的子树在后序序列的结束位置
     * @param in 中序序列
     * @param startIn 需要构建的子树在中序序列的开始位置
     * @param endIn 需要构建的子树在中序序列的结束位置
     * @return 构建的子树
     */
    public static TreeNode rebuildByInAndBack(int[] back, int startBack, int endBack, int[] in, int startIn, int endIn) {
        if (startBack > endBack || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(back[endBack]);
        for (int i = startIn; i <= endIn ; i++) {
            if (in[i] == back[endBack]) {
                root.left = rebuildByInAndBack(back, startBack, startBack + i - startIn - 1,
                                                in, startIn, i - 1);
                root.right = rebuildByInAndBack(back, endBack - (endIn - i), endBack - 1,
                                                  in, i + 1, endIn);
                break;
            }
        }
        return root;
    }


}

```

# 华为机试精华
## 字符串的一些处理
### String类的一些常用方法
```java
/**
 * @author zhiwen.qi
 * @description
 * @date 2020/2/8 9:27
 */
public class TestSomething {

    public static void main(String[] args) {
        String s = "this is a sentence ";

        //以空格分割字符串。函数可以加第二参数int limit表示分割几次
        String[] divides = s.split(" ");    //divides: ["this", "is", "a", "sentence"]

        //下标从0开始。截取从第5个字符到第7-1个字符。如果不加第二个参数表示从一个参数位置截取到末尾
        String sub = s.substring(5,7);  //sub: "is"

        //获取字符串第一次出现的位置。
        int firstOccurence = s.indexOf("e");    //firstOccurence: 11

        //获取字符串最后一次出现的位置
        int lastOccurence = s.lastIndexOf("e");     //lastOccurence: 17

        //替换所有单个字符
        String charReplaced = s.replace('s', 'x');      //charReplaced: "thix ix a xentence "

        //替换目标字符串
        String stringRepalced = s.replaceAll("en","us");    //stringRepalced: "this is a sustusce "

        //去掉首尾多余的空格
        String trimString = s.trim();   //trimString: "this is a sentence"

        //转换为小写
        String lowerString = s.toLowerCase();   //lowerString: "this is a sentence "

        //转换为大写
        String upperString = s.toUpperCase();  //upperString: "THIS IS A SENTENCE "

        //忽略大小写进行比较
        boolean isEqualsIgnore = s.equalsIgnoreCase(upperString);   //isEqualsIgnore: true

        //获取指定位置字符。
        char c = s.charAt(1); //c: 'h'

        //转换为字符数组
        char[] cs = s.toCharArray(); //cs: ['t','h','i','s',' ',...]

        //通过字符数组构建新的字符串
        String newString = new String(cs);  //newString: "this is a sentence "

        //获取某个基本类型的字符串值
        String stringValue = String.valueOf(12);    //stringValue: "12"

        //使用StringBuilder构建字符串。String的+运算符本质上也是通过StringBuilder去做的
        StringBuilder builder = new StringBuilder();
        //追加字符串
        builder.append("str");
        //追加字符
        builder.append('a');
        //追加数字
        builder.append(1);
        //指定位置插入
        builder.insert(2,2);
        //构建String
        String buildString = builder.toString();    //buildString: "st2ra1"
        //字符串反转
        String reverseString = builder.reverse().toString();

        //测试字符串是否与给定的正则表达式匹配。此为是否包含h或者s
        boolean isMatch = s.matches(".*[hs].*");    //isMatch: true

        //是否以某个字符串结尾
        boolean isEndWith = s.endsWith("ce");   //isEndWith: true

        //将数值字符串转为整数
        int num = Integer.valueOf("102");   //num: 102

        //判断字符是否是字母
        boolean isLetter = Character.isLetter('m');
        //判断字符是否大写字母
        boolean isUpper = Character.isUpperCase('A');
        //判断字符是否小写字母
        boolean isLower = Character.isLowerCase('a');
        //判断字符是否是数字
        boolean isDigit = Character.isDigit('9');
        //字符是否在b-h范围内。本质比较ASCII码
        char d = 'd';
        boolean isIn = false;
        if (c >= 'b' && c <= 'h') {
            isIn = true;
        }
        //小写字母转大写字母。小写字母ASCII码比大写字母的大32.需要强转
        char upperD = (char) (d + 32);
    }

}

```

### 进制转换与字符串前面补0的方法
```Long.parseInt(String s, int radix)```可以将指定进制(radix标明)的字符串转换为整数值,返回值为long类型

```Long.toString(long value, int radix)```可以将整数值转换为指定进制(radix标明)的字符串

```java
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String commonIP = sc.nextLine();
            String tenIP = sc.nextLine();
            System.out.println(ipToTen(commonIP));
            System.out.println(tenToIP(tenIP));
        }
        sc.close();
    }
    
    public static String ipToTen(String ip) {
        if (ip == null || ip.length() == 0) {
            return "";
        }
        String[] sections = ip.split("\\.");
        if (sections.length != 4) {
            return  "";
        }else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < sections.length; i++) {
                int n = Integer.parseInt(sections[i]);
                if (n > 255 || n < 0) {
                    return "";
                }else {
                    String bStr = "00000000" + Integer.toBinaryString(n);
                    bStr = bStr.substring(bStr.length() - 8);
                    builder.append(bStr);
                }
            }
            long tenValue = Long.parseLong(builder.toString(), 2);
            return Long.toString(tenValue, 10);
        }
    }
    
    public static String tenToIP(String ipTen) {
        if (ipTen == null || ipTen.length() == 0) {
            return "";
        }
        long value = Long.parseLong(ipTen, 10);
        String bString = "00000000000000000000000000000000" + Long.toString(value, 2);
        bString = bString.substring(bString.length() - 32);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= 24; i += 8) {
            String s = bString.substring(i, i +8);
            int val = Integer.parseInt(s, 2);
            if (val < 0 || val > 255) {
                return "";
            }else {
                builder.append(val + ".");
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
    
}
```
### 字符串分割-保留字母，其他符号作为分割符号
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        reString(s);
    }
    
    public static void reString(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        String[] ss = s.split("[^a-zA-Z]+");
        StringBuilder builder = new StringBuilder();
        for(int i = ss.length - 1; i >= 0; i--) {
           builder.append(ss[i] + " ");
        }
        System.out.println(builder.toString().trim());
    }
}
```

### 求最长回文子串
```java
package algorithm.thoughts.others;

/**
 * @author zhiwen.qi
 * @description 求字符串的最长回文子串
 * @date 2020/2/11 8:20
 */
public class MaxPalindrome {

    public static void main(String[] args) {
        String str = "abcdcbafabcdck";
        //String str = "acbbcbds";
//        System.out.println(manacher(str));
        System.out.println(myMethod(str));
    }

    /**
     * Manacher算法源字符串初始处理。为合并对称中心为一个字符和两个字符的情况
     * @param str 目标字符串
     * @return 添加"#"符号后的数组
     */
    public static char[] manacherString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }

    /***
     * Manacher算法求最长回文子串
     * @param str 目标字符串
     * @return 最长回文子串的长度
     */
    public static int manacher(String str){
        if(str == null || str.length() < 1){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] radius = new int[charArr.length];
        int R = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < radius.length; i++) {
            radius[i] = R > i ? Math.min(radius[2*c-i],R-i+1):1;
            while(i+radius[i] < charArr.length && i - radius[i] > -1){
                if(charArr[i-radius[i]] == charArr[i+radius[i]]){
                    radius[i]++;
                }else{
                    break;
                }
            }
            if(i + radius[i] > R){
                R = i + radius[i]-1;
                c = i;
            }
            max = Math.max(max,radius[i]);
        }
        return max-1;
    }


    public static int myMethod(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            builder.append("#");
            builder.append(s.charAt(i));
        }
        builder.append("#");
        char[] cs = builder.toString().toCharArray();
        int[] radius = new int[cs.length];
        int max = Integer.MIN_VALUE;
        int len = 0;
        for (int i = 0; i < radius.length; i++) {
            while ( i - len >= 0 && i + len <= radius.length - 1) {
                int leftBorder = i - len;
                int rightBorder = i + len;
                if (cs[leftBorder] == cs[rightBorder]) {
                    len++;
                    radius[i] = len;
                }else {
                    break;
                }
            }
            len = 0;
            max = Math.max(max, radius[i]);
        }
        return max - 1;
    }
}
```

## 空间换时间
### 随机数的去重和排序
```java
import java.util.Scanner;
/**
* N个1-1000的随机数，去掉其中重复的数字并对N个数排序
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] result = new Main().getResult(a);
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
```
## Map的使用
### TreeMap按照key排序
```java
import java.util.TreeMap;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
        int size=sc.nextInt();
        while(sc.hasNext()){
            int key=sc.nextInt();    
            int val=sc.nextInt();
            if(map.containsKey(key)){
                map.put(key,val+map.get(key));
            }else{
                map.put(key,val);
            }
        }
        for(int key:map.keySet()){
            System.out.println(key+" "+map.get(key));
        }
    }

}
```

## 递归的使用
### 汽水瓶问题
```java
/**
*有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。
*小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，
*方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，
*用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
*然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
*如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
*/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(sc.hasNext()) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }else {
                list.add(num);
            }
        }
        sc.close();
        for(Integer n : list) {
            System.out.println(computeResult(n));
        }
    }
    
    public static int computeResult(int num) {
        if (num == 0 || num == 1) {
            return 0;
        }
        if (num == 2) {
            return 1;
        }
        int left = num % 3 + num / 3;
        return num / 3 + computeResult(left);
    }
    
}
```

### 最大公约数最小公倍数
```java
package algorithm.huawei;

/**
 * @author zhiwen.qi
 * @description 求最大公约数和最小公倍数
 * 有如下定理
 * 辗转相除法原理。有两数x和y，那么(mx+/-ny)与x和y有相同的最大公约数.
 * 假设x/y=n...c那么x-ny = c。x-ny是上述mx+/-ny的特例，也就是说c与x和y有最大公约数。于是可以利用余数不断缩小最大公约数范围
 * @date 2020/2/11 9:21
 */
public class GCDandLCM {

    public static void main(String[] args) {
        System.out.println(gcd(25,10));
        System.out.println(lcm(25,10));
    }

    /**
     * 求最大公约数
     * @param a 数a
     * @param b 数b
     * @return 最大公约数
     */
    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    /**
     * 最小公倍数
     * @param a 数a
     * @param b 数b
     * @return 最小公倍数
     */
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int gcd = gcd(a, b);
        return (a / gcd) * (b / gcd) * gcd;
    }

}

```

### 到达目标位置的最小跳跃次数
```java
package algorithm.huawei;

/**
 * @author zhiwen.qi
 * @description
 * 给定一个数组a，初始位置0，数组每个元素代表当前位置向后跳的步数。第1次可以选择向后跳1<=n<a.length / 2步，求到数组末尾跳的最小次数
 * 如果无法到达返回-1
 * 例：
 * [7, 5, 9, 6, 8, 3, 5, 4, 2, 3, 5, 2]
 * 第1次选择到a[2]，然后根据a[2]的值，往后跳9步，到了数组末尾。这样总共跳2次，其余方案都多于2次，所以最小次数为2.
 * @date 2020/2/13 19:48
 */
public class ArrayMinStep {

    public static void main(String[] args) {
//        int[] a= {7, 5, 6, 8, 3, 5, 4, 2, 3, 5, 2};
        int[] a = {7,1,1,1};
        System.out.println(getMin(a, a.length - 1));
    }

    /**
     * 获取到达指定位置跳的最小次数
     * @param a 数组
     * @param end 目标位置
     * @return 到达目标位置跳的最小次数
     */
    public static int getMin(int[] a, int end) {
        if (end <= a.length / 2 - 1) {  //如果目标位置在数组前一半，则可第1次选择直接到达目标位置
            return 1;
        }else {
            //如果第1次能到达的那些位置中，下一次能到目标位置，那么到目标位置最小次数为2
            for (int i = 1; i <= a.length / 2 - 1; i++) {
                if (i + a[i] == end) {
                    return 2;
                }
            }
            //如果目标位置不能由第1次到达位置跳1次到到达，说明需要由数组后一半的某个位置跳1次到达
            for (int i = a.length / 2; i < end; i++) {
                if (i + a[i] == end) {  //数组后一半某个i位置能跳1次到达目标位置
                    int minTo_i = getMin(a, i);   //到i位置时的最小步数
                    if (minTo_i != - 1) {   //如果i位置可达，那么到目标位置的最小次数为到i位置最小次数加1
                        return minTo_i + 1;
                    }
                }
            }
            return -1;
        }
    }

}

```

# 技巧性强的一些问题
## 剑指offer
### 二维数组的查找
```java
package algorithm.swordToOffer;

/**
 * @author zhiwen.qi
 * @description 二维数组的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @date 2020/2/24 10:13
 */
public class SearchIn2DArray {

    public static void main(String[] args) {
        //1  2  3
        //3  4  5
        //5  6  7
        int[][] a = {{1,2,3},{3,4,5},{5,6,7}};
        System.out.println(hasNumber(a, 3));
    }


    /**
     * 在二维数组中查找目标数。起始位置选择数组左下角，
     * 如果目标数比当前位置大，则当前位置所在列以及左边列都比当前数小，此时可将指针右移；
     * 如果目标数比当前位置小，则当前位置所在行以及下边行都比当前数大，此时可将指针上移；
     * @param array 二维数组
     * @param target 目标数
     */
    public static boolean hasNumber(int[][] array, int target) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            throw new RuntimeException("not valid array");
        }
        //小于最小数，大于最大数直接返回false
        if (target < array[0][0] || target > array[array.length - 1][array[0].length - 1] - 1) {
            return false;
        }
        //开始从左下角查找
        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j <= array[0].length - 1) {
            if (target > array[i][j]) {  //目标数比当前位置大，则当前位置列以及左边列都比当前数小，指针右移
                j++;
            }else if (target < array[i][j]) {  //目标数比当前位置小，则当前位置行以及下边行都比当前数大，指针上移
                i--;
            }else { //目标数与当前位置数相等
                System.out.println("find at: " + i + "," + j);
                return true;
            }
        }
        return false;
    }
}

```

## 华为机试
### 字母的排序
```java
/**
*将输入的字符串中的字母重新按字母序排序。大小写字母间保留原来顺序。非字母保留原来位置
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(getResult(s));
        }
        sc.close();
    }
    
   
    public static String getResult(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] cs = s.toCharArray();
        StringBuilder builder = new StringBuilder();

        //按26个字母从a-z的顺序开始判断字符串中的每一个字符。
        for (int i = 0; i < 26; i++) {
            char c = (char)(i + 'A');
            //遍历字符串，看当前目标字母是否在字符串中(不区分大小写)
            for (int j = 0; j < cs.length; j++) {
                //如果字符串中有当前字母(不区分大小写)，则加入到字母的构造的字符串
                if (cs[j] == c || cs[j] == (char)(c + 32)) {
                    builder.append(cs[j]);
                }
            }
        }
        //将非字母字符插入到构造的字符串的正确位置
        for (int k = 0; k < cs.length; k++) {
            if (!Character.isLetter(cs[k])) {
                builder.insert(k,cs[k]);
            }
        }
        return builder.toString();
    }
}
```

### 字母去重并且记录出现的顺序
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String key = sc.nextLine();
            String target = sc.nextLine();
            System.out.println(encrypt(key, target));
        }
    }
    
    public static String encrypt(String key, String target) {
        if (key == null || key.length() == 0 || target == null || target.length() == 0) {
            return "";
        }
        int[] occured = new int[26];
        char[] order = new char[26];
        int orderIndex = 0;
        String upperKey = key.toUpperCase();
        for (int i = 0; i < key.length(); i++) {
            int val = upperKey.charAt(i) - 'A';
            if (val >=0 && val < 26) {
                if (occured[val] == 0) {
                    occured[val] = 1;
                    order[orderIndex] = (char)(val + 'A');
                    orderIndex++;
                }
            }
        }
        orderIndex = 0;
        StringBuilder b1 = new StringBuilder();
        StringBuilder b2 = new StringBuilder();
        for (int j = 0; j < occured.length; j++) {
            if (occured[j] == 1) {
                char orderChar = order[orderIndex];
                b1.append(orderChar);
                orderIndex++;
            }else {
                b2.append((char)(j + 'A'));
            }
        }
        String mapValue = b1.append(b2).toString();
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < target.length(); k++) {
            char c = target.charAt(k);
            int cVal = -1;
            if (c >= 'A' && c <= 'Z') {
                cVal = c - 'A';
                result.append(mapValue.charAt(cVal));
            }else if ( c >= 'a' && c <= 'z') {
                cVal = c - 'a';
                result.append((char)(mapValue.charAt(cVal) + 32));
            }else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
```

### 求解并从小到大输出质数因子
```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        sc.close();
        System.out.println(getPrimeFactor(num));
    }

    public static String getPrimeFactor(long number) {
        StringBuilder result = new StringBuilder();
        for (long i = 2; i <= number; i++) {
            if (number % i == 0) {
                result.append(i + " ");
                number = number / i;
                //关键代码，重置了i，当前循环结束后i++。使得下一次重新从2开始
                i = 1;
            }
        }
        return result.toString();
    }

}
```

### 计算整数2进制中1的个数
```java
package algorithm.huawei;

/**
 * @author zhiwen.qi
 * @description
 * @date 2020/1/8
 */
public class BinaryCount1 {

    public static void main(String[] args) {
        int num = 5;
        System.out.println(get1Count(num));
    }

    /**
     * 计算正整数二进制中1的个数
     * @param num 正整数
     * @return 二进制中1的个数
     */
    public static int get1Count(int num) {
        if (num < 0) {
            return -1;
        }
        int count = 0;
        while (num != 0) {
            //二进制的数与1做按位与运算，最后一位如果为1结果才不为0
            if ((num & 1) != 0) {
                count++;
            }
            //比较完之后向右移动一位
            num = num >> 1;
        }
        return count;
    }

}

```

### 计算多组砝码的可能称重
现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
注：
称重重量包括0
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] weight = new int[n];
            int[] count = new int[n];
            for (int i = 0; i < n ;i++) {
                weight[i] = sc.nextInt();
            }
            for (int i = 0; i < n ;i++) {
                count[i] = sc.nextInt();
            }
            System.out.println(getResult(weight, count));
        }
        sc.close();
    }
    
    public static int getResult(int[] weight, int[] count) {
        //set用来存储可能的重量
        Set<Integer> set = new HashSet<>();
        //初始化第一组砝码的可能重量
        for (int i = 0; i <= count[0] ; i++) {
            //将第一组砝码可能的重量加入到set中
            set.add(weight[0] * i);
        }
        //添加后续砝码组
        for (int i = 1; i < weight.length; i++) {
            //list用来记录之前已计算出的可能重量
            List<Integer> list = new ArrayList<>(set);
            //针对当前砝码组，计算每次放入j个当前砝码
            for (int j = 0; j <= count[i]; j++) {
                //计算当前砝码组放入j个时，与之前的所有可能重量相加后的结果
                for (int k = 0; k < list.size(); k++) {
                    set.add(weight[i] * j + list.get(k));
                }
            }
        }
        return set.size();
    }
}
```



### 计算中缀表达式的值
```java
package algorithm.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhiwen.qi
 * @description 求包含+，-，*，/，(，)，以及整数，求表达式的值。可能输入非有效字符，需要自行判断
 * 例子：字符串1+2*3-(2*5-2)/2，表达式计算值为3
 * 思路：先转换为后缀表达式，再根据后缀表达式求值。
 * 例子转为为后缀表达式为123*+25*2-2/-
 * @date 2020/2/13 20:52
 */
public class SimpleExpressionValue {

    public static void main(String[] args) {
//        System.out.println(calBackExpression("123*+25*2-2/-"));
        String in = "1+2*3-(2*5-2)/2";
        String back = transferToBack(in);
        System.out.println(back);
        System.out.println(calBackExpression(back));
    }

    /**
     * 计算后缀表达式的值
     * @param expression 表达式
     * @return 表达式计算后的结果
     */
    public static int calBackExpression(String expression) {
        if (expression == null || expression.length() == 0) {
            throw new RuntimeException("null or empty expression!");
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            String e = expression.charAt(i) + "";
            if (e.matches("[0-9]*")) {  //为数字的情况(Integer.valueOf()会处理类似0012这种情况)直接入栈
                stack.push(e);
            }else if (e.matches("[\\+\\-\\*\\/]")) {    //为四则运算符号将数出栈并将计算后的结果入栈
                String n2 = stack.pop();
                String n1 = stack.pop();
                //
                int res = calValue(n1, n2, e);
                stack.push(res + "");
            }
        }
        return Integer.valueOf(stack.pop());
    }

    /**
     * 根据运算符计算结果
     * @param n1 次顶元素
     * @param n2 顶元素
     * @param operator 运算符
     * @return 计算结果
     */
    private static int calValue(String n1, String n2, String operator) {
        switch (operator) {
            case "+":
                return Integer.valueOf(n1) + Integer.valueOf(n2);
            case "-":
                return Integer.valueOf(n1) - Integer.valueOf(n2);
            case "*":
                return Integer.valueOf(n1) * Integer.valueOf(n2);
            case "/":
                return Integer.valueOf(n1) / Integer.valueOf(n2);
            default:
                throw new RuntimeException("无该类型运算符!");
        }
    }

    /**
     * 中缀表达式转换成后缀表达式
     * @param inExpression
     * @return
     */
    public static String transferToBack(String inExpression) {
        //栈用来处理运算符和括号
        Stack<String> stack = new Stack<>();
        //队列用于存储后缀表达式每个元素
        List<String> list = new ArrayList<>();
        for (int i = 0; i < inExpression.length(); i++) {
            String e = inExpression.charAt(i) + "";
            if (e.matches("[0-9]*")) {
                list.add(e);
            }else if (e.matches("[\\+\\-\\*\\/]")) {
                if (!stack.isEmpty()) {  //当栈不为空时
                    //将优先级大于或等于当前运算符的元素出栈入列
                    while (!stack.isEmpty() && !"(".equals(stack.lastElement()) && !comparePriority(e, stack.lastElement())) {
                        list.add(stack.pop());
                    }
                }
                //处理完后推入元素
                stack.push(e);
            }else if ("(".equals(e)) {
                stack.push(e);
            }
            else if (")".equals(e)) {
                //遇到右括号，则找上一个左括号。然后把中间的运算符全部放入队列中
                while (!"(".equals(stack.lastElement())) {
                    list.add(stack.pop());
                }
                //循环结束后，栈顶元素必定为"("
                stack.pop();
            }
        }
        //剩余元素加入到队列中
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        StringBuffer bf = new StringBuffer();
        for (String s : list) {
            bf.append(s);
        }
        return bf.toString();
    }

    private static boolean comparePriority(String o1, String o2) {
        return getPriority(o1) > getPriority(o2);
    }

    private static int getPriority(String str) {
        switch (str) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            default:
                throw new RuntimeException("没有该类型的运算符！");
        }
    }

}

```


