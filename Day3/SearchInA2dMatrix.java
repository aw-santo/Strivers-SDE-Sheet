package Day3;

public class SearchInA2dMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 283;

        System.out.println(searchMatrix(matrix, target));
    }
    
    static boolean searchMatrix(int[][] matrix, int target) {
        int last;
        int n = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            last = matrix[i][n-1];
            if (target == last) {
                return true;
            }
            if (target < last) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }
    
    static boolean binarySearch(int[] arr, int target) {
        int l = 0;
        int h = arr.length - 1;
        int mid;

        while (l <= h) {
            mid = l + (h-l)/2;

            if (arr[mid] == target) {
                return true;
            }

            if (target < arr[mid]) {
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return false;
    }
}
