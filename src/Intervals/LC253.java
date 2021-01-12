package Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC253 {

    public int minMeetingRooms(int[][] intervals) {
        // design endpoint for each interval and implement comparable,
        // when tie, end go first and start go later

        //cc

        List<EndPoint> list = new ArrayList<>();

        for (int[] intv : intervals) {
            list.add(new EndPoint(intv[0], true));
            list.add(new EndPoint(intv[1], false));
        }

        Collections.sort(list);

        int max = 0, cur = 0;

        for (EndPoint l : list) {
            if (l.isStart) {
                cur++;
            } else {
                cur--;
            }

            max = Math.max(max, cur);
        }

        return max;

    }

    class EndPoint implements Comparable<EndPoint> {
        private int val;
        private boolean isStart;

        public EndPoint (int val, boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }

        @Override
        public int compareTo (EndPoint that) {
            if (this.val != that.val) {
                return this.val - that.val;
            } else {
                return !this.isStart ? -1 : 1;
            }
        }
    }
}
