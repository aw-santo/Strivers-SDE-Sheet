package Day1;

import java.util.ArrayList;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        // ArrayList<Integer> subarr = new ArrayList<>();
        // System.out.println(maxSubArray2(arr, subarr));
        // for (int i = subarr.get(0); i <= subarr.get(1); i++) {
        //     System.out.print(arr[i] + " ");
        // }
        System.out.println(maxSubArray3(arr));
    }

    static int maxSubArray1(int[] nums, ArrayList<Integer> subarr) {
        if (nums == null || nums.length<=0) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if(sum>max) {
                    max = sum;
                    subarr.clear();
                    subarr.add(i);
                    subarr.add(j);
                }
            }
        }
        return max;
    }

    static int maxSubArray2(int[] nums, ArrayList<Integer> subarr) {
        if (nums == null || nums.length<=0) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int curr_sum = 0;
            for (int j = i; j < nums.length; j++) {
                curr_sum += nums[j];
                if (curr_sum > max) {
                    max = curr_sum;
                    subarr.clear();
                    subarr.add(i);
                    subarr.add(j);
                }
            }
        }
        return max;
    }

    static int maxSubArray3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > max) max = sum;

            if(sum < 0) sum = 0;
        }

        return max;
    }
}
