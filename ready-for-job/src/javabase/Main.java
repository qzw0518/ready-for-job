package javabase;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args){
        int[] a = {3,1,2,4,5,6,2,7,9};
        reOrderArray(a);
    }

    public static void reOrderArray(int [] array) {
        if(array==null || array.length ==0){
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
