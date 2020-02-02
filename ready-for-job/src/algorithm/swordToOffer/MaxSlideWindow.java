package algorithm.swordToOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhiwen.qi
 * @description
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 最大值数组为{4,4,6,6,6,5}
 * @date 2020/1/16
 */
public class MaxSlideWindow {


    public static void main(String[] args) throws Exception {
        int[] a = {2,3,4,2,6,2,5,1};
        int size = 3;
        System.out.println(Arrays.toString(maxInWindows(a, size)));
    }

    public static int[] maxInWindows(int [] nums, int size) throws Exception {
        //入参检查
        if (nums == null || nums.length < 1 || size < 1 || nums.length < size) {
            throw new Exception("illegal window size or array length");
        }
        //窗口最大值数组
        int[] maxValues = new int[nums.length - size + 1];
        //初始化第一个窗口最大值
        maxValues[0] = getWindowMax(nums, 0, size);
        //如果数组长度为1，直接返回
        if (nums.length < 2) {
            return maxValues;
        }
        //从第二个元素开始遍历，直到最后一个窗口
        for (int i = 1; i < nums.length - size + 1; i++) {
            //如果当前窗口最后一个元素（新加入的元素）大于等于前一个窗口最大值，更新当前窗口最大值
            if (nums[i + size - 1] >= maxValues[i - 1]) {
                maxValues[i] = nums[i + size - 1];
            }else {
                //新加入元素比前一个窗口最大值小，且前一个窗口最大值被移出
                if (nums[i - 1] == maxValues[i - 1]) {
                    maxValues[i] = getWindowMax(nums, i, size);
                }else {
                    maxValues[i] = maxValues[i - 1];
                }
            }
        }
        return maxValues;
    }

    public static int getWindowMax(int[] nums, int index, int size) {
        int max = Integer.MIN_VALUE;
        for (int i = index; i < size + index; i++) {
            if (i > nums.length - 1) {
                break;
            }
            if (nums[i] >= max) {
                max = nums[i];
            }
        }
        return max;
    }

}
