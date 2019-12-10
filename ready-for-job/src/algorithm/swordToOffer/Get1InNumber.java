package algorithm.swordToOffer;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/26
 */
public class Get1InNumber {

    /**
     * 统计整数二进制数中1的个数。一个数与1做并运算，如果二进制末位是1，则结果为1，否则为0
     * @param num 十进制整数
     * @return 二进制格式1的个数
     */
    public int get1Count(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) > 0) {
                count++;
            }
            //右移一位
            num = num >> 1;
        }
        return count;
    }

}
