package BDFS.hard;

import java.util.ArrayList;
import java.util.List;

public class LC305 {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();

        if (positions == null) {
            return result;
        }

        UnionFind uf = new UnionFind(m * n);
        int nr = m;
        int nc = n;

        for (int[] pos : positions) {
            int r = pos[0];
            int c = pos[1];
            int idx = r * n + c;
            uf.addLand(idx);

            for (int[] direction : DIRECTIONS) {
                int rr = r + direction[0];
                int cc = c + direction[1];
                int nidx = rr * nc + cc;

                if (rr >= 0 && rr < nr && cc >= 0 && cc < nc && uf.isLand(nidx)) {
                    if (!uf.find(idx, nidx)) {
                        uf.union(idx, nidx);
                    }
                }
            }

            result.add(uf.getNumberOfLand());
        }

        return result;
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    class UnionFind {

        private int[] parent;
        private int[] size;
        private int numIslands;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            this.numIslands = 0;
        }

        public int findRoot(int p) {
            int cur = p;
            while (cur != parent[cur]) {
                parent[cur] = parent[parent[cur]];
                cur = parent[cur];
            }

            parent[p] = cur;
            return parent[p];
        }

        public boolean find(int p, int q) {
            return findRoot(p) == findRoot(q);
        }

        public void union(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);

            if (size[pRoot] < size[qRoot]) {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }

            numIslands--;
        }

        public void addLand(int p) {
            if (parent[p] > 0 && size[p] > 0) {
                return;
            }

            parent[p] = p;
            size[p] = 1;
            numIslands++;
        }

        public int getNumberOfLand() {
            return this.numIslands;
        }

        public boolean isLand(int p) {
            return size[p] > 0;
        }
    }
}
