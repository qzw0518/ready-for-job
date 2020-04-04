package algorithm.huawei;

/**
 * @author zhiwen.qi
 * @description
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述:
 *  输入一个整数（int类型）
 *
 * 输出描述:
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入
 * 5
 * 输出
 * 2
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
