package algorithm.thoughts.dynamic_programing;

/**
 * 动态规划：0-1背包问题
 * @author zhiwen.qi
 * @description 有N个物品，和容量为C的背包。每件物品只能使用一次。
 *              第i件物品的价值是vi,体积是wi。
 *              求解将那些物品装入背包，可以使这些物品的总体积不超过背包容量，且总价值最大。
 *              输出最大价值。
 *              输入示例：
 *              4 5 //4件物品，容量为5
 *              1 2 //第一件体积1，价值2
 *              2 4
 *              3 4
 *              4 5
 *              输出示例：
 *              8
 * @date 2020/1/13
 */
public class Pack0_1 {
    public static void main(String[] args) {
        int[] v = {2, 4, 4, 5};
        int[] w = {1, 2, 3, 4};
        int n = 4;
        int capacity = 5;
        System.out.println(getMaxValueImproved(n, capacity, v, w));

    }

    /**
     * 求容量为capacity时，n个物品的最大价值。考察子问题：
     * @param n 物品个数
     * @param capacity 背包容量
     * @param v 价值数组
     * @param w 体积数组
     * @return 最大价值
     */
    public static int getMaxValueImproved(int n, int capacity, int[] v, int[] w) {
        int[] maxVal = new int[capacity+1];
        //i代表前i件物品
        for (int i = 0; i < n ; i++) {
            for (int j = capacity; j >= w[i] ; j--) {
                maxVal[j] = Math.max(maxVal[j], maxVal[j-w[i]] + v[i]);
            }
        }
        return maxVal[capacity];
    }


}
