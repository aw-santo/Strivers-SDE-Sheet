package Day2;

import java.util.*;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        
        // matrix = rotate(matrix);
        
        rotate1(matrix);
        
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[j][n-i-1] = matrix[i][j];
            }
        }
        return arr;
    }

    static void rotate1(int[][] matrix) {
        // take transpose
        // them each row reverse!
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
    static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
}
