package algorithm.swordToOffer;

/**
 * @description: 找出数组中只出现一次的那个数，其余都出现两次。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @version: 1.0
 * @author: zhiwen.qi@hand-china.com
 * @date: 2019/9/17
 */
public class OddCountNumber {
	public static void main(String[] args){
		int[] a = {4,5,7,1,2,3,2,9,9,4,5,3,1};
		System.out.println(getNumber(a));
	}

	/**
	 * 利用异或运算，异或运算遵循交换分配率。如 (a xor b) xor c = a xor (b xor c)
	 * @param a
	 * @return
	 */
	public static int getNumber(int[] a){
		for (int i=1;i<a.length;i++){
			a[i] = a[i-1] ^ a[i];
		}
		return a[a.length-1];
	}

}
