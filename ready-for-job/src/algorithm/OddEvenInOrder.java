package algorithm;

/**
 * @author zhiwen.qi@hand-china.com
 * @version 1.0
 * @ClassName OddEvenInOrder
 * @description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @date 2019/10/23 20:18
 * @since JDK 1.8
 */
public class OddEvenInOrder {
    public static void main(String[] args){

        int[] a = {3,1,2,4,5,6,2,7,9};
        reOrderArray(a);
    }

    public static void reOrderArray(int [] array) {
        if( array == null || array.length ==0){
            return ;
        }
        int m = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2!=0){
                int tmp = array[i];
                int j=i;
                while(j>m){
                    array[j] = array[j-1];
                    j--;
                }
                m=j+1;
                array[j] = tmp;
            }
        }
    }
}
