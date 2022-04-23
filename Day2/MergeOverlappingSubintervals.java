package Day2;

import java.util.*;

public class MergeOverlappingSubintervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge(intervals);
        for (int[] is : ans) {
            System.out.println(Arrays.toString(is));
        }
    }
    
    static int[][] merge(int[][] intervals) {
        ArrayList<int[]> arr =  new ArrayList<>();

        if (intervals == null || intervals.length == 0) {
            return arr.toArray(new int[0][]);
        }

        // sort first
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            }
            else {
                arr.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }

        arr.add(new int[]{start, end});

        return arr.toArray(new int[0][]);
    }
}
