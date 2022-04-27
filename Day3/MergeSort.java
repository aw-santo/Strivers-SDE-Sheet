package Day3;
import java.util.*;
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr, int low, int high) {
        if (arr.length <= 1 || low >= high) {
            return;
        }
        int mid = low + (high-low)/2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

        merge(arr, low, mid, high);
    }
    static void merge(int[] arr, int l, int m, int h) {
        int[] arrN = new int[h-l+1];
        int c = 0;

        int c1 = l;
        int c2 = m+1;

        while (c1 <= m && c2 <= h) {
            if (arr[c1] < arr[c2]) {
                arrN[c] = arr[c1];
                c1++;
            }
            else {
                arrN[c] = arr[c2];
                c2++;
            }
            c++;
        }

        while (c1 <= m) {
            arrN[c] = arr[c1];
            c++; c1++;
        }
        while (c2 <= h) {
            arrN[c] = arr[c2];
            c++; c2++;
        }

        for (int i = l; i <= h; i++) {
            arr[i] = arrN[i-l];
        }
    }
}
