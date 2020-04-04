package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiwen.qi
 * @description
 * 题目描述
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * 输入描述:
 * 将一个英文语句以单词为单位逆序排放。
 *
 * 输出描述:
 * 得到逆序的句子
 *
 * 示例1
 * 输入
 * I am a boy
 * 输出
 * boy a am I
 * @date 2020/2/6 16:44
 */
public class ReverseSentence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sen = sc.nextLine();
        sc.close();
        System.out.println(reverseSentence(sen));
    }

    public static String reverseSentence(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return "";
        }
        String[] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            builder.append(words[i] + " ");
        }
        return builder.toString().trim();
    }
}
