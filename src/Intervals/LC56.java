package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56 {

    public int[][] merge(int[][] intervals) {

        //cc
        // sort by the start point and then use cur compare to next, if overlap, update cur, if not overlap, add cur into result


        Arrays.sort(intervals, (n1, n2) -> n1[0] - n2[0]);

        int[] cur = intervals[0];

        List<int[]> result = new ArrayList<>();

        for (int i = 1 ; i < intervals.length ; i++ ) {
            int[] next = intervals[i];

            if (next[0] <= cur[1]) {
                cur = new int[]{cur[0], Math.max(next[1], cur[1])}; // need to check included
            } else {
                result.add(new int[]{cur[0], cur[1]});
                cur = next;
            }
        }

        result.add(cur);

        int[][] res = new int[result.size()][cur.length];

        res = result.toArray(res);

        return res;

    }
}
