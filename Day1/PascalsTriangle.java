package Day1;
// https://leetcode.com/problems/pascals-triangle/

import java.util.*;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }

    static List<List<Integer>> generate(int n) {

        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        List<Integer> row, pre = null;

        for (int i = 0; i < n; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i) {
                    row.add(1);
                }
                else {
                    row.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = row;
            ls.add(row);
        }
        return ls;
    }
}
