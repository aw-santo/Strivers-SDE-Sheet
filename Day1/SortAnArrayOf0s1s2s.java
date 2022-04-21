package Day1;
import java.util.Arrays;

public class SortAnArrayOf0s1s2s {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(nums));
        sortNos1(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sortNos(int[] nums) {
        int z = 0, o = 0, t = 0;

        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    z++;
                    break;
            
                case 1:
                    o++;
                    break;

                case 2:
                    t++;
                    break;
            }
        }
        System.out.println(z + " " + o +  " " + t);
        for (int i = 0; i < z; i++) {
            nums[i] = 0;
        }

        for (int i = z; i < z+o; i++) {
            nums[i] = 1;
        }

        for (int i = z+o; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    static void sortNos1(int[] nums) {
        int l = 0, m = 0, h = nums.length-1;

        while (m<=h) {
            if (nums[m]==0) {
                swap(nums, l, m);
                l++; m++;
            }
            else if (nums[m]==1) {
                m++;
            }
            else {
                swap(nums, m, h);
                m++; h--;
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
