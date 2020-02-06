package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiwen.qi
 * @description
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 *
 * 输出描述:
 * 整数N，最后一个单词的长度。
 *
 * 示例1
 * 输入
 * hello world
 * 输出
 * 5
 * @date 2020/2/5 16:52
 */
public class LastWordLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        LastWordLength m = new LastWordLength();
        while (sc.hasNext()) {
            s = sc.nextLine();
            System.out.println(m.getLastWordLength2(s));
        }
        sc.close();
    }

    public int getLastWordLength(String s){
        int count = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == ' '){
                count = 0;
            }else{
                count++;
            }
        }
        return count;
    }

    public int getLastWordLength2(String s){
        if(s == null || s.length() == 0) {
            return -1;
        }
        int lastSpaceIndex = s.lastIndexOf(" ");
        if(lastSpaceIndex == -1) {
            return s.length();
        }
        return s.length() - 1 - lastSpaceIndex;
    }

}
