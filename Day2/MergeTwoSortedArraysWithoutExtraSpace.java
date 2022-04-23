package Day2;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        System.out.println("main: "+Arrays.toString(nums1));
        merge2(nums1, m, nums2, n);
        System.out.println("main: "+Arrays.toString(nums1));
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];
        int c = 0;
        int c1 = 0;
        int c2 = 0;

        while (c1<m && c2<n) {
            if (nums1[c1] <= nums2[c2]) {
                arr[c] = nums1[c1];
                c1++;
            }
            else {
                arr[c] = nums2[c2];
                c2++;
            }
            c++;
        }

        while (c1 < m) {
            arr[c] = nums1[c1];
            c1++; c++;
        }

        while (c2 < n) {
            arr[c] = nums2[c2];
            c2++; c++;
        }
        System.out.println(Arrays.toString(nums1));
        for (int i = 0; i < arr.length; i++) {
            nums1[i] = arr[i];
        }
        System.out.println(Arrays.toString(nums1));
    }

    static void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < m; i++) {
            if (nums1[i] > nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;

                int first = nums2[0];
                int j;
                for (j = 1; j < n && nums2[j] < first; j++) {
                    nums2[j-1] = nums2[j];
                }
                nums2[j-1] = first;
            }
        }
        for (int i = m; i < m+n; i++) {
            nums1[i] = nums2[i-m];
        }
    }
}
