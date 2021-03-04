package BDFS.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LC542 {

    // search problem
    // graph, i, j vertex, 4 edge, undirected, 1 weight
    // search
    // start point? how many times? start point, super zero, 1 times
    // BFS
    // Feb 22th 1:15PM
    // Feb 22th 1:34PM
    // forget to add visited on converted
    public int[][] updateMatrix(int[][] matrix) {
        //cc

        int nr = matrix.length;
        int nc = matrix[0].length;

        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[nr][nc];
        int[][] result = new int[nr][nc];
        addAllZeros(matrix, queue, visited);

        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int current = queue.poll();

                int r = current / nc;
                int c = current % nc;

                for (int[] direction : DIRECTIONS) {
                    int rr = r + direction[0];
                    int cc = c + direction[1];

                    if (!(rr < 0 || rr >= nr || cc < 0 || cc >= nc || visited[rr][cc] || matrix[rr][cc] == 0)) {
                        result[rr][cc] = length + 1;
                        queue.offer(rr * nc + cc);
                        visited[rr][cc] = true;
                    }
                }
            }
            length++;
        }

        return result;
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void addAllZeros(int[][] matrix, Queue<Integer> queue, boolean[][] visited) {
        int nr = matrix.length;
        int nc = matrix[0].length;

        for (int i = 0 ; i < nr ; i++ ) {
            for (int j = 0 ; j < nc ; j++ ) {
                if (matrix[i][j] == 0) {
                    queue.offer(i * nc + j);
                    visited[i][j] = true;
                }
            }
        }
    }
}
