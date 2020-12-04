package BDFS.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return matrix;
        }

        Queue<Point> queue = new LinkedList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];

        addAllZeros(matrix, queue, rows, cols);
        int minLength = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0 ; i < size ; i++ ) {
                Point current = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    int x = current.x + direction[0];
                    int y = current.y + direction[1];

                    if (x >= 0 && y >= 0 && x < rows && y < cols && result[x][y] == 0 && matrix[x][y] == 1) {

                        result[x][y] = minLength;
                        queue.offer(new Point(x, y));
                    }
                }
            }
            minLength++;
        }

        return result;
    }

    private void addAllZeros(int[][] matrix, Queue<Point> queue, int rows, int cols) {
        for (int i = 0 ; i < rows ; i++ ) {
            for (int j = 0 ; j < cols ; j++ ) {
                if (matrix[i][j] == 0) {
                    queue.offer(new Point(i, j));
                }
            }
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
