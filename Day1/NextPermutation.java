package Day1;

import java.util.Arrays;
// https://leetcode.com/problems/next-permutation/

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3};
        System.out.println(Arrays.toString(arr));
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void nextPermutation(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int i = arr.length - 2;

        while (i>=0 && arr[i] >= arr[i+1]) i--;

        if (i>=0) {
            int j = arr.length - 1;
            while(arr[j] <= arr[i]) j--;
            swap(arr, i, j);
        }
        reverse(arr, i+1, arr.length-1);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] arr, int i, int j) {
        while(i<j) swap(arr, i++, j--);
    }
}
