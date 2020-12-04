package BDFS.hard;
import java.util.*;
public class LC317 {
    // put each 1 to bfs and calculate the distance to each 0, and add to a global int[][]
    // 08/31 11:40 am
    public int shortestDistance(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }

        Queue<Point> queue = new LinkedList<>();
        int rows = grid.length, cols = grid[0].length;
        int[][] cost = new int[rows][cols];
        int[][] count = new int[rows][cols];

        int countNumber = 0;
        for (int i = 0 ; i < rows ; i++ ) {
            for (int j = 0 ; j < cols ; j++ ) {
                if (grid[i][j] == 1) {
                    countNumber++;
                    bfs(grid, queue, cost, rows, cols, i, j, count);
                }
            }
        }
        int result = searchLowestCost(cost, grid, count, countNumber);

        return result != Integer.MAX_VALUE ? result : -1;
    }

    private int searchLowestCost(int[][] cost, int[][] grid, int[][] count, int countNumber) {
        Integer min = Integer.MAX_VALUE;
        for (int i = 0 ; i < cost.length ; i++ ) {
            for (int j = 0 ; j < cost[0].length ; j++ ) {
                if (grid[i][j] != 1 && grid[i][j] != 2 && count[i][j] == countNumber && cost[i][j] < min) {
                    min = cost[i][j];
                }
            }
        }

        return min;
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void bfs(int[][] grid, Queue<Point> queue, int[][] cost, int rows, int cols, int i, int j, int[][] count) {

        int minLength = 1;
        queue.offer(new Point(i, j));
        boolean[][] visited = new boolean[rows][cols];
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int a = 0 ; a < size ; a++ ) {
                Point current = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    int x = current.x + direction[0];
                    int y = current.y + direction[1];

                    if (x >= 0 && y >= 0 && x < rows && y < cols) {

                        if (grid[x][y] == 0 && !visited[x][y]) {
                            queue.offer(new Point(x, y));
                            cost[x][y] += minLength;
                            count[x][y] += 1;
                            visited[x][y] = true;
                        }

                    }
                }
            }
            minLength++;
        }
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

    public static void main(String args[]) {
        int[][] input = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        LC317 lc = new LC317();
        System.out.println(lc.shortestDistance(input));

    }
}
