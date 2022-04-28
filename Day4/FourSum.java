package Day4;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum1(nums, target));
    }
    static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int x = target - nums[i] - nums[j] - nums[k];
                    if (Arrays.binarySearch(nums, k+1, nums.length-1, x) >= 0) {
                        ArrayList<Integer> ar = new ArrayList<>();
                        ar.add(nums[i]);
                        ar.add(nums[j]);
                        ar.add(nums[k]);
                        ar.add(x);
                        Collections.sort(ar);
                        ls.add(ar);
                    }
                }
            }
        }
        return ls;
    }

    static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> ls = new ArrayList<>();

        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int last_3_sum = target - nums[i];

            for (int j = i+1; j < n; j++) {
                int last_2_sum = last_3_sum - nums[j];

                int front = j+1;
                int back = n-1;

                while (front < back) {
                    if (nums[front] + nums[back] > last_2_sum) {
                        back--;
                    }
                    else if (nums[front] + nums[back] < last_2_sum) {
                        front++;
                    }
                    else {
                        ArrayList<Integer> on = new ArrayList<>();
                        on.add(nums[i]);
                        on.add(nums[j]);
                        on.add(nums[front]);
                        on.add(nums[back]);

                        ls.add(on);

                        while (front < back && nums[front] == on.get(2)) {
                            front++;
                        }

                        while (front < back && nums[back] == on.get(3)) {
                            back--;
                        }
                    }
                }
                while (j+1 < n && nums[j+1] == nums[j]) {
                    j++;
                }
            }
            while (i+1 < n && nums[i+1] == nums[i]) {
                i++;
            }
        }
        return ls;
    }
}
