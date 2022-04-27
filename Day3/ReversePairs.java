package Day3;

public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        System.out.println(reversePairs(nums));
    }

    static int reversePairs(int[] nums) {
        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > (long)(2*nums[j])) {
                    p++;
                }
            }
        }
        return p;
    }
}
