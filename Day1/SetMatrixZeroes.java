package Day1;

// https://leetcode.com/problems/set-matrix-zeroes/
import java.util.Arrays;

import javax.smartcardio.ATR;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{-4,-2147483648,6,-7,0},{-8,6,-8,-6,0},{2147483647,2,-9,-6,-10}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        // System.out.println(Integer.MIN_VALUE);
    }

    // 1. 
    /* static void setZeroes(int[][] matrix) {
        if (matrix.length <= 0) {
            return;
        }
        int rows = matrix.length, cols = matrix[0].length;

        int[] dummy1 = new int[rows];
        int[] dummy2 = new int[cols];
        Arrays.fill(dummy1, -1);
        Arrays.fill(dummy2, -1);

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(matrix[i][j] == 0) {
                    dummy1[i] = 0;
                    dummy2[j] = 0;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dummy1[i]==0 || dummy2[j]==0) {
                    matrix[i][j] = 0;
                }
            }
        }
    } */

    // 2. 
    static void setZeroes(int[][] matrix) {
        if (matrix.length <= 0) {
            return;
        }

        int col = 1, rows = matrix.length, cols = matrix[0].length;

        for(int i=0; i<rows; i++) {
            if (matrix[i][0] == 0) {
                col = 0;
            }
            for(int j=1; j<cols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i=rows-1; i>=0; i--) {
            for(int j=cols-1; j>=1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(col == 0)
                matrix[i][0] = 0;
        }
    }
}