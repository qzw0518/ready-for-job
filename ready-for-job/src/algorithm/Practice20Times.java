package algorithm;

import java.util.Arrays;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/11/2
 */
public class Practice20Times {

    public static void main(String[] args) {
        int[] a = {9,6,4,12,5,7,9,1,10};
//        new Practice20Times().quickSort(a,0,a.length-1);
        new Practice20Times().mergeSort(a,0,a.length-1);
//        new Practice20Times().bubbleSort(a);
        System.out.println(Arrays.toString(a));

    }

    public void quickSort(int[] a , int l, int r) {
      if (l < r) {
          int i = l;
          int j = r;
          int x = a[i];
          while (i < j) {
              while (i < j && a[j] > x) {
                  j--;
              }
              if (i < j) {
                  a[i] = a[j];
                  i++;
              }
              while (i < j && a[i] < x) {
                  i++;
              }
              if (i < j) {
                  a[j] = a[i];
                  j--;
              }
              a[i] = x;
              quickSort(a,l,i-1);
              quickSort(a,i+1,r);
          }
      }
    }

    public void mergeSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(a,l,mid);
        mergeSort(a,mid+1,r);
        merge(a,l,mid,r);
    }

    private void merge(int[] a, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = 0;
        int[] tmp = new int[r-l+1];
        while (i <= mid && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            }else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= r) {
            tmp[k++] = a[j++];
        }
        for (int m = 0; m < k;m++) {
            a[l+m] = tmp[m];
        }
        tmp = null;
    }

    public static void bubbleSort(int[] a){
        if (a == null || a.length == 0) {
            return;
        }
        int tmp = 0;
        for (int i = a.length;i > 0; i--) {
            for (int j = 1;j < i;j++) {
                if (a[j-1] > a[j]) {
                    tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
            }
        }
    }

}
