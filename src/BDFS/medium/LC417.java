package BDFS.medium;

import java.nio.channels.Pipe;
import java.util.*;
public class LC417 {

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static enum Ocean { PACIFIC, ALTANTIC }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException();
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] altlantic = new boolean[rows][cols];
        Queue<Point> queue = new LinkedList<>();
        Set<List<Integer>> result = new HashSet<>();


        loadAllPacificShortestPath(matrix, pacific, queue);
        bfs(matrix, pacific, altlantic, queue, result);
        loadAllAltanticShortestPath(matrix, altlantic, queue);
        bfs(matrix, altlantic, pacific, queue, result);

        List<List<Integer>> list = new ArrayList<>(result);

        return list;
    }

    private void loadAllPacificShortestPath(int[][] matrix, boolean[][] current, Queue<Point> queue) {
        int row = 0, col = 0;

        for (int i = 0 ; i < matrix.length ; i++ ) {
            current[i][col] = true;
            queue.offer(new Point(i, col));
        }

        for (int i = 0 ; i < matrix[0].length ; i++ ) {
            current[row][i] = true;
            queue.offer(new Point(row, i));
        }
    }

    private void loadAllAltanticShortestPath(int[][] matrix, boolean[][] current, Queue<Point> queue) {

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        for (int i = 0 ; i < matrix.length ; i++ ) {
            current[i][col] = true;
            queue.offer(new Point(i, col));
        }

        for (int i = 0 ; i < matrix[0].length ; i++ ) {
            current[row][i] = true;
            queue.offer(new Point(row, i));
        }


    }

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void bfs(int[][] matrix, boolean[][] self, boolean[][] other, Queue<Point> queue, Set<List<Integer>> result) {

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == 0 && current.y == 4) {
                System.out.println(current.x);
            }

            if (other[current.x][current.y]) {
                result.add(Arrays.asList(current.x, current.y));
            }

            for (int[] direction : DIRECTIONS) {
                int x = current.x + direction[0];
                int y = current.y + direction[1];

                if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] >= matrix[current.x][current.y] && !self[x][y]) {
                    self[x][y] = true;
                    queue.offer(new Point(x, y));
                }
            }
        }
    }

    public static void main(String[] args) {
        LC417 lc = new LC417();
        int[][] input2 = {{1,2},{4,3}};
        int[][] input = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        lc.pacificAtlantic(input2);
    }
}
