package Intervals;

import java.util.*;

public class LC218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        // sort left and right with it height,
        // need an ds to maintain the heights and find max,
        // use maxHeap

        // for each endpoint, if add to group and maxHeight changed, need to add an point

        // if tie, 1. if both start: high go first, lower go later
        //          2. if both end : lower go first, high go later
        //          3. if left end, right start, left < right, left go first, right go second
        //          4. if left end, right start, left > right, left go first, right go second

        //cc

        List<List<Integer>> result = new ArrayList<>();

        List<EndPoint> eps = new ArrayList<>();

        for (int[] b : buildings) {
            eps.add(new EndPoint(b[0], b[2], true));
            eps.add(new EndPoint(b[1], b[2], false));
        }

        Collections.sort(eps);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);

        for (EndPoint e : eps) {
            if (e.isStart) {
                if (maxHeap.isEmpty() || maxHeap.peek() < e.height) {
                    result.add(Arrays.asList(e.val, e.height));
                }
                maxHeap.add(e.height);
            } else {
                maxHeap.remove(e.height); // because we need to check if the height is been shadow
                if (maxHeap.isEmpty() || maxHeap.peek() < e.height) {
                    result.add(Arrays.asList(e.val, maxHeap.isEmpty() ? 0 : maxHeap.peek()));
                }
            }
        }

        return result;
    }

    class EndPoint implements Comparable<EndPoint> {

        private int val;
        private int height;
        private boolean isStart;

        public EndPoint (int val, int height, boolean isStart) {
            this.val = val;
            this.height = height;
            this.isStart = isStart;
        }

        @Override
        public int compareTo (EndPoint that) { // need to think about order!!!
            if (this.val != that.val) {
                return this.val - that.val;
            } else {
               if (this.isStart && that.isStart) {
                   return that.height - this.height;
               } else if (!this.isStart && !that.isStart) {
                   return this.height - that.height;
               } else {
                   return this.isStart ? -1 : 1;
               }
            }
        }


    }

    public static void main (String[] args) {
        int[][] input = new int[][]{{1,2,1},{1,2,2},{1,2,3}};
        LC218 lc218 = new LC218();
        lc218.getSkyline(input);
    }

}
