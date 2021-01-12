package BDFS.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC378 {

    public int kthSmallest(int[][] matrix, int k) {
        // use minHeap with bfs

        //cc

        int nc = matrix[0].length, nr = matrix.length;

        PriorityQueue<Point> minHeap = new PriorityQueue<>(k, (n1, n2) -> n1.y - n2.y);
        minHeap.add(new Point(0, 0, matrix[0][0]));

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (k-- > 0) {
            Point current = minHeap.poll();

            if (k == 0) {
                return current.val;
            }

            int x = current.x;
            int y = current.y;

            for (int[] direction : DIRECTIONS) {
                int xx = x + direction[0];
                int yy = y + direction[1];
                int position = yy * nc + xx;

                if (xx < 0 || yy < 0 || xx >= nc || yy >= nr || visited.contains(position)) {
                    continue;
                }

                minHeap.add(new Point(xx, yy, matrix[yy][xx]));
                visited.add(position);
            }
        }

        return k == -1 ? minHeap.peek().y : -1;


    }

    class Point {

        int x;
        int y;
        int val;

        public Point (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

    }

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}};


    public static void main(String args[]) {
        int[][] input = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;

        LC378 lc378 = new LC378();
        lc378.kthSmallest(input, k);
    }
}
