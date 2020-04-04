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
