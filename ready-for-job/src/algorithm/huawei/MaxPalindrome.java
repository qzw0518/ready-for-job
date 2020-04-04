package algorithm.huawei;

/**
 * @author zhiwen.qi
 * @description 求字符串的最长回文子串
 * @date 2020/2/11 8:20
 */
public class MaxPalindrome {

    public static void main(String[] args) {
        String str = "abcdcbafabcdck";
        //String str = "acbbcbds";
//        System.out.println(manacher(str));
        System.out.println(myMethod(str));
    }

    /**
     * Manacher算法源字符串初始处理。为合并对称中心为一个字符和两个字符的情况
     * @param str 目标字符串
     * @return 添加"#"符号后的数组
     */
    public static char[] manacherString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }

    /***
     * Manacher算法求最长回文子串
     * @param str 目标字符串
     * @return 最长回文子串的长度
     */
    public static int manacher(String str){
        if(str == null || str.length() < 1){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] radius = new int[charArr.length];
        int R = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < radius.length; i++) {
            radius[i] = R > i ? Math.min(radius[2*c-i],R-i+1):1;
            while(i+radius[i] < charArr.length && i - radius[i] > -1){
                if(charArr[i-radius[i]] == charArr[i+radius[i]]){
                    radius[i]++;
                }else{
                    break;
                }
            }
            if(i + radius[i] > R){
                R = i + radius[i]-1;
                c = i;
            }
            max = Math.max(max,radius[i]);
        }
        return max-1;
    }


    public static int myMethod(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            builder.append("#");
            builder.append(s.charAt(i));
        }
        builder.append("#");
        char[] cs = builder.toString().toCharArray();
        int[] radius = new int[cs.length];
        int max = Integer.MIN_VALUE;
        int len = 0;
        for (int i = 0; i < radius.length; i++) {
            while ( i - len >= 0 && i + len <= radius.length - 1) {
                int leftBorder = i - len;
                int rightBorder = i + len;
                if (cs[leftBorder] == cs[rightBorder]) {
                    len++;
                    radius[i] = len;
                }else {
                    break;
                }
            }
            len = 0;
            max = Math.max(max, radius[i]);
        }
        return max - 1;
    }


}