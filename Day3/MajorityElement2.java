package Day3;

public class MajorityElement2 {
    public static void main(String[] args) {
        
    }
    static int majorityElement(int[] nums) {
        int count = 0;
        int ele = 0;

        for (int i : nums) {
            if (count == 0) {
                ele = i;
            }
            if (ele == i) {
                count++;                
            } else count--;
        }
        return ele;
    }
}
