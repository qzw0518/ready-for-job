package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiwen.qi
 * @description
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 *
 * 示例1
 * 输入
 * ABCDEF
 * A
 * 输出
 * 1
 * @date 2020/2/5 17:06
 */
public class CharCountInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();
        char target = sc.nextLine().charAt(0);
        sc.close();
        System.out.println(new CharCountInString().getContainsCount(src,target));
    }


    public int getContainsCount(String s,char a){
        if (s == null) {
            return -1;
        }
        int count = 0;
        a = Character.toLowerCase(a);
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (a == s.charAt(i)) {
                count++;
            }
        }
        return count;
    }


}
