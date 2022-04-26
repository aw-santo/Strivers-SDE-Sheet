package Day3;

import java.util.*;

public class GridUniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
    static int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];
        for (int[] is : ans) {
            Arrays.fill(is, -1);
        }
        int num = helper(0, 0, m, n, ans);

        if (m==1 && n==1) {
            return num;
        }
        return ans[0][0];
    }
    static int helper(int i, int j, int m, int n, int[][] ans) {
        if (i==m-1 && j==n-1) {
            return 1;
        }
        if (i>m-1 || j>n-1) {
            return 0;
        }
        if (ans[i][j] != -1) {
            return ans[i][j];
        }
        else {
            return ans[i][j] = helper(i+1, j, m, n, ans) + helper(i, j+1, m, n, ans);
        }
    }
}
