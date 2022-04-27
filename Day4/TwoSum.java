package Day4;
import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum1(nums, target)));
    }
    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int[] twoSum1(int[] nums, int target) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n1=0, n2=0;
        int i = 0, j = nums.length-1;
        while (i < j) {
            if (arr[i]+arr[j] == target) {
                n1 = arr[i]; n2 = arr[j];
            }
            if (arr[i]+arr[j] > target) {
                j--;
            }
            else {
                i++;
            }
        }
        for (int j2 = 0; j2 < arr.length; j2++) {
            if (n1 == nums[j2]) {
                i = j2;
            }
            else if (n2 == nums[j2]) {
                j = j2;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nums));
        return new int[]{i, j};
    }
}
