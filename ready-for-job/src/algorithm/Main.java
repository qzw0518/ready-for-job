package algorithm;


import java.util.Arrays;
import java.util.Scanner;


public class Main{
    public static void main(String[] args){
        String[] sa = {"BTssa","Tsag","cat","card","two","too","up","boat","boot"};
        quickSort(sa,0,sa.length-1);
        for (int j=0;j<sa.length;j++) {
            System.out.println(sa[j]);
        }
    }

    public static boolean s1BeforeS2(String s1, String s2) {
        int minLen = Math.min(s1.length(),s2.length());
        for (int i=0;i<minLen;i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return false;
            }else if (s1.charAt(i) < s2.charAt(i)) {
                return true;
            }
        }
        return true;
    }

    public static void quickSort(String[] sa, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            String x = sa[i];
            while (i < j) {
                while (i < j && s1BeforeS2(x,sa[j])) {
                    j--;
                }
                if (i < j) {
                    sa[i] = sa[j];
                    i++;
                }
                while (i < j && s1BeforeS2(sa[i],x)) {
                    i++;
                }
                if (i < j) {
                    sa[j] = sa[i];
                    j--;
                }
                sa[i] = x;
                quickSort(sa,left,i-1);
                quickSort(sa,i+1,right);
            }
        }
    }
}
