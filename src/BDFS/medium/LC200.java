package BDFS.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LC200 {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0 ; i < grid.length ; i++ ) {
            for (int j = 0 ; j < grid[0].length ; j++ ) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;


    }

    private void dfs(char[][] grid, int i, int j) {

        if (!valid(grid, i, j)) {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    private boolean valid(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            return true;
        }

        return false;
    }

    //BFS //TODO find the best naming for integer

//    public int numIslands(char[][] grid) {
//
//        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
//            return 0;
//        }
//        int count = 0;
//        int nc = grid[0].length;
//        int nr = grid.length;
//        for (int c = 0 ; c < nc ; c++ ) {
//            for (int r = 0 ; r < nr ; r++ ) {
//                if (grid[r][c] == '1') {
//                    grid[r][c] = '0';
//                    bfs(grid, r, c);
//                    count++;
//                }
//            }
//        }
//
//        return count;
//
//    }
//
//    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
//
//    private void bfs(char[][] grid, int r, int c) {
//
//        Queue<Integer> queue = new LinkedList<>();
//        int nc = grid[0].length;
//        int nr = grid.length;
//        queue.offer(r * nc + c);
//
//        while (!queue.isEmpty()) {
//            Integer current = queue.poll();
//            int row = current / nc;
//            int col = current % nc;
//            for (int[] direction : DIRECTIONS) {
//                int rr = row + direction[0];
//                int cc = col + direction[1];
//
//                if (rr >= 0 && rr < nr && cc >= 0 && cc < nc && grid[rr][cc] == '1') {
//                    queue.offer(rr * nc + cc);
//                    grid[rr][cc] = '0';
//                }
//            }
//        }
//    }

//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
//            return 0;
//        }
//
//        int nr = grid.length;
//        int nc = grid[0].length;
//
//        UnionFind uf = new UnionFind(nr * nc);
//
//        for (int r = 0 ; r < nr ; r++ ) {
//            for (int c = 0 ; c < nc ; c++ ) {
//                if (grid[r][c] == '1') {
//                    int idx = r * nc + c;
//                    uf.addLand(idx);
//
//                    for (int[] direction : DIRECTIONS) {
//                        int rr = r + direction[0];
//                        int cc = c + direction[1];
//                        int nidx = rr * nc + cc;
//                        if (rr >= 0 && rr < nr && cc >= 0 && cc < nc && uf.isLand(nidx) && !uf.find(idx, nidx)) {
//                            uf.union(idx, nidx);
//                        }
//                    }
//                }
//            }
//        }
//
//        return uf.getNumberOfLand();
//    }
//
//    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//
//    class UnionFind {
//
//        private int[] parent;
//        private int[] size;
//        private int numIslands;
//
//        public UnionFind(int n) {
//            this.parent = new int[n];
//            this.size = new int[n];
//            this.numIslands = 0;
//        }
//
//        public int findRoot(int p) {
//            int cur = p;
//            while (cur != parent[cur]) {
//                parent[cur] = parent[parent[cur]];
//                cur = parent[cur];
//            }
//
//            parent[p] = cur;
//            return parent[p];
//        }
//
//        public boolean find(int p, int q) {
//            return findRoot(p) == findRoot(q);
//        }
//
//        public void union(int p, int q) {
//            int pRoot = findRoot(p);
//            int qRoot = findRoot(q);
//
//            if (size[pRoot] < size[qRoot]) {
//                parent[pRoot] = qRoot;
//                size[qRoot] += size[pRoot];
//            } else {
//                parent[qRoot] = pRoot;
//                size[pRoot] += size[qRoot];
//            }
//
//            numIslands--;
//        }
//
//        public void addLand(int p) {
//            if (parent[p] > 0 && size[p] > 0) {
//                return;
//            }
//
//            parent[p] = p;
//            size[p] = 1;
//            numIslands++;
//        }
//
//        public int getNumberOfLand() {
//            return this.numIslands;
//        }
//
//        public boolean isLand(int p) {
//            return size[p] > 0;
//        }
//    }
}
