package BDFS.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC694 {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int nr = grid.length, nc = grid[0].length;

        boolean[][] visited = new boolean[nr][nc];
        Set<Set<Integer>> distinct = new HashSet<>();

        for (int j = 0 ; j < grid.length ; j++ ) {
            for (int i = 0 ; i < grid[0].length ; i++ ) {
                if (grid[j][i] == 1 && !visited[j][i]) {
                    bfs(grid, i, j, visited, distinct);
                }
            }
        }

        return distinct.size();
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void bfs(int[][] grid, int i, int j, boolean[][] visited, Set<Set<Integer>> distinct) {

        int nr = grid.length, nc = grid[0].length;

        Queue<Integer> queue = new LinkedList<>();
        int start = j * nc + i;
        queue.offer(start);
        visited[j][i] = true;
        Set<Integer> set = new HashSet<>();
        set.add((j - j) * 2 * nc + (i - i));

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int r = current / nc;
            int c = current % nc;

            for (int[] direction : DIRECTIONS) {
                int rr = r + direction[0];
                int cc = c + direction[1];

                if (rr < 0 || cc < 0 || rr >= nr || cc >= nc || grid[rr][cc] != 1 || visited[rr][cc]) {
                    continue;
                }

                queue.offer(rr * nc + cc);
                visited[rr][cc] = true;
                set.add((rr - j) * 2 * nc + (cc - i));
            }
        }

        distinct.add(set);
    }
}
