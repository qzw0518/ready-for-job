package javaLearning.base;

/**
 * @author zhiwen.qi
 * @description 字符串方法
 * @date 2019/10/27
 */
public class AboutString {

    public static void main(String[] args) {
        String s = "abcdefg";
        int len = s.length();
        char c = s.charAt(0);
        boolean f = s.matches("a");
        String ss = s.concat("hijk");
        s.replaceAll("regex","new");
        s.equals("aa");
        s.contains("ab");
        s.split(" ");
        s.toLowerCase();
        s.toUpperCase();
        s.substring(1,3);
        String noSpace = s.trim();
        String inStaticPool = s.intern();
        StringBuilder sbd = new StringBuilder("sssa");
        sbd.append(2);
        sbd.append(3.1);
        String getString = sbd.toString();
        sbd.reverse();
        sbd.insert(2,'2');
        StringBuffer sbf = new StringBuffer();
    }
}
