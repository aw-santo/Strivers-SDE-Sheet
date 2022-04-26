package Day3;

import java.util.*;


public class MajorityElement3 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        System.out.println(majorityElement1(nums));

        ArrayList<Integer> maj = majorityElement2(nums);
        HashSet<Integer> set = new HashSet<>(maj);

        for (int e : set) {
            System.out.println(e + " ");
        }
    }

    static List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int count;
        for (int i = 0; i < nums.length; i++) {
            count = 1;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > nums.length/3) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    static List<Integer> majorityElement1(int[] nums) {
        HashMap<Integer, Integer> set = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            set.put(nums[i], set.getOrDefault(nums[i], 0) + 1);
        }

        // value repeats
        // for (int i = 0; i < nums.length; i++) {
        //     if (set.get(nums[i]) > nums.length/3) {
        //         ans.add(nums[i]);
        //     }
        // }

        // using keySet() --> only get unique values
        for (int x : set.keySet()) {
            if (set.get(x) > nums.length/3) {
                ans.add(x);
            }
        }
        return ans;
    }

    static ArrayList<Integer> majorityElement2(int[] nums) {
        int n1 = -1, n2 = -1, c1 = 0, c2 = 0, len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == n1) {
                c1++;
            }
            else if (nums[i] == n2) {
                c2++;
            }
            else if (c1 == 0) {
                n1 = nums[i];
            }
            else if (c2 == 0) {
                n2 = nums[i];
            }
            else {
                c1--; c2--;
            }
        }
        c1 = 0; c2 = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == n1) {
                c1++;
            }
            else if (nums[i] == n2) {
                c2++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if (c1 > len/3) {
            ans.add(n1);
        }
        if (c2 > len/3) {
            ans.add(n2);
        }

        return ans;
    }
}
