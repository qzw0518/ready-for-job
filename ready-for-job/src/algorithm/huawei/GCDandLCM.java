package algorithm.huawei;

/**
 * @author zhiwen.qi
 * @description 求最大公约数和最小公倍数
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
