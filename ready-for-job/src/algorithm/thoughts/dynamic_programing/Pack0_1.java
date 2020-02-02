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
     * 计算最大价值。
     * @description
     * 1.用二维数组dp [ i ] [ j ]，表示在面对第 i 件物品，且背包容量为  j 时所能获得的最大价值
     * 2.01背包之所以叫“01”，就是一个物品只能拿一次，或者不拿。
     * 那我们就分别来讨论拿还是不拿。
     * （1）j < w[i] 的情况，这时候背包容量不足以放下第 i 件物品，只能选择不拿
     * dp [ i ] [ j ] = dp [ i - 1 ] [ j ]；
     * （2）j>=w[i] 的情况，这时背包容量可以放下第 i 件物品，我们就要考虑拿这件物品是否能获取更大的价值。
     * ~如果拿取，dp [ i ] [ j ] = dp [ i - 1 ] [ j - w [ i ] ] + v [ i ]。(如果拿取，那么前i件最大价值 = 前i-1件最大价值 + v[i]。问题转化为求前i-1件最大价值。注意此时前i-1件容量已确定为j-w[i])
     * ~如果不拿，dp [ i ] [ j ] = dp [ i-1 ] [ j ]
     * 到底拿不拿呢？要看拿与不拿那个结果更大了。
     * 看，这用到了动态规划的思想：在求值时会用到之前状态的结果。
     * 我们就可以得出状态转移方程了。
     * 1 if(j>=w[i])
     * 2     dp[i][j]=max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
     * 3 else
     * 4     dp[i][j] = dp[i-1][j];
     * @param n 物品总数
     * @param capacity 背包容量
     * @param v 价值数组(value)
     * @param w 体积数组(weight)
     * @return
     */
    public static int getMaxValue(int n, int capacity, int[] v, int[] w) {
        return -1;
    }

    /**
     * 优化
     * @param n 物品个数
     * @param capacity 背包容量
     * @param v 价值数组
     * @param w 体积数组
     * @return 最大价值
     */
    public static int getMaxValueImproved(int n, int capacity, int[] v, int[] w) {
        int[] maxVal = new int[capacity+1];
        for (int i = 0; i < n ; i++) {
            for (int j = capacity; j >= w[i] ; j--) {
                maxVal[j] = Math.max(maxVal[j], maxVal[j-w[i]] + v[i]);
            }
        }
        return maxVal[capacity];
    }


}
