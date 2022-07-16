package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class LC305NumberOfIslandsIi{
    public static void main(String[] args) {
        Solution solution = new LC305NumberOfIslandsIi().new Solution();
        int[][] queries = {{0,1},{0, 0}};
        solution.numIslands2(1,2, queries);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //TODO need to rewrite with more clear logic

        /*
        search problem in 2d matrix => graph
        positons dynamic added
        dfs or union find
        dfs : tc kmn sc mn
        union find: tc klogk sc k
        */
        public final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            //cc
            List<Integer> result = new ArrayList<>();
            UnionFind uf = new UnionFind(m * n, positions.length);

            for (int[] pos : positions) {
                int i = pos[0], j = pos[1], idx = i * n + j;
                uf.addIsland(idx);
                for (int[] direction : DIRECTIONS) {
                    int ii = i + direction[0];
                    int jj = j + direction[1];
                    int next = ii * n + jj;

                    if (next == 2) {
                        int test = 0;
                    }

                    if (ii < 0 || ii >= m || jj < 0 || jj >= n || !uf.isIsland(next)) {
                        continue;
                    }

                    if (!uf.find(idx, next)) {
                        uf.union(idx, next);
                    }
                }
                result.add(uf.getNumberOfIslands());
            }

            return result;
        }

        class UnionFind {
            private int[] parent;
            private int[] size;
            private int numberOfIslands;

            public UnionFind(int n, int m) {
                this.parent = new int[n];
                this.size = new int[n];
                for (int i = 0 ; i < n ; i++ ) {
                    parent[i] = -1;
                }
                this.numberOfIslands = 0;
            }

            public int getRoot(int p) {
                int cur = p;
                while (parent[cur] != cur) {
                    parent[cur] = parent[parent[cur]];
                    cur = parent[cur];
                }
                parent[p] = cur;
                return cur;
            }

            public boolean find(int p, int q) {
                return getRoot(p) == getRoot(q);
            }

            public void union(int p, int q) {
                int rootP = getRoot(p), rootQ = getRoot(q);

                if (size[rootP] > size[rootQ]) {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                } else {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                }
                numberOfIslands--;
            }

            public int getNumberOfIslands() {
                return numberOfIslands;
            }

            public void addIsland(int p) {
                if (parent[p] >= 0 && size[p] > 0) {
                    return;
                }

                parent[p] = p;
                size[p] = 1;
                numberOfIslands++;
            }

            public boolean isIsland(int p) {
                return parent[p] >= 0;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}