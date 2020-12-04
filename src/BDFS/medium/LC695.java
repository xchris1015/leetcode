package BDFS.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LC695 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int y = 0 ; y < grid.length ; y++ ) {
            for (int x = 0 ; x < grid[0].length ; x++ ) {
                if (grid[y][x] == 1 && !visited[y][x]) {
                    max = Math.max(max, bfs(grid, visited, x, y));
                }
            }
        }

        return max;
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int bfs(int[][] grid, boolean[][] visited, int x, int y) {
        int nr = grid.length, nc = grid[0].length;

        Queue<Integer> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.offer(y * nc + x);
        int size = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            size++;
            int r = current / nc;
            int c = current % nc;

            for (int[] direction : DIRECTIONS) {
                int rr = r + direction[0];
                int cc = c + direction[1];

                if (valid(rr, cc, grid, visited)) {
                    queue.offer(rr * nc + cc);
                    visited[rr][cc] = true;
                }
            }
        }

        return size;
    }

    private boolean valid(int rr, int cc, int[][] grid, boolean[][] visited) {
        int nr = grid.length, nc = grid[0].length;

        if (rr >= 0 && rr < nr && cc >= 0 && cc < nc && grid[rr][cc] == 1 && !visited[rr][cc]) {
            return true;
        }

        return false;
    }
}
