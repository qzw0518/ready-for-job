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
