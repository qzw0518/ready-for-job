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
