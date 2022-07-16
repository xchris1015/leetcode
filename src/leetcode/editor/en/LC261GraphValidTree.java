package leetcode.editor.en;

import java.util.*;

public class LC261GraphValidTree{
    public static void main(String[] args) {
        Solution solution = new LC261GraphValidTree().new Solution();
        int[][] edges = {{0,1}, {0, 2}, {0,3}, {1, 4}};
        solution.validTree(5, edges);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //TODO
        /*
    Tree : E = V - 1
    search problem in a graph,
    construct graph, V => idx, neig ds => Vertex, Hashset connected in edges

    only for directed graph or with prev node, dfs: check cycle, if not, valid => Tc V + E => V, SC, V

    union find : check connected component number == 1 at end, because E = V - 1 and undirected, which means connected component > 1 => cycle Tc nlogn Sc, V
    */



        //union find
        public boolean validTree(int n, int[][] edges) {
            if (edges.length != n - 1) {
                return false;
            }

//         UnionFind uf = new UnionFind(n);

//         for (int i = 0 ; i < n ; i++ ) {
//             uf.addComponent(i + 1);
//         }

//         for (int[] edge : edges) {
//             int i = edge[0] + 1, j = edge[1] + 1;
//             if (!uf.find(i, j)) {
//                 uf.union(i, j);
//             } else {
//                 return false;
//             }
//         }

//         return uf.getComponents() == 1;

            Map<Integer, Set<Integer>> graph = constructGraph(n, edges);
            int[] status = new int[n];
            if (dfs(0, graph, 0, status)) {
                return false;
            }

            for (int i = 0 ; i < status.length ; i++ ) {
                if (status[i] != 2) {
                    return false;
                }
            }

            return true;
        }

        private Map<Integer, Set<Integer>> constructGraph(int n, int[][] edges) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();

            for (int i = 0 ; i < n ; i++ ) {
                graph.put(i, new HashSet<>());
            }

            for (int[] edge : edges) {
                int x = edge[0], y = edge[1];
                Set<Integer> neigX = graph.getOrDefault(x, new HashSet<>());
                neigX.add(y);
                graph.put(x, neigX);
                Set<Integer> neigY = graph.getOrDefault(y, new HashSet<>());
                neigY.add(x);
                graph.put(y, neigY);
            }

            return graph;
        }

        private boolean dfs(int cur, Map<Integer, Set<Integer>> graph, int prev, int[] status) {
            if (status[cur] == 1) {
                return true;
            }

            if (status[cur] == 2) {
                return false;
            }

            status[cur] = 1;
            Set<Integer> nexts = graph.getOrDefault(cur, new HashSet<>());
            for (int next : nexts) {
                if (next == prev) {
                    continue;
                }

                if (dfs(next, graph, cur, status)) {
                    return true;
                }
            }

            status[cur] = 2;
            return false;
        }

        class UnionFind {
            private int[] parent;
            private int[] size;
            private int components;

            public UnionFind(int n) {
                this.parent = new int[n + 1];
                this.size = new int[n + 1];

            }

            private int getRoot(int p) {
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
                int rootQ = getRoot(q), rootP = getRoot(p);

                if (size[rootQ] > size[rootP]) {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                } else {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                }
                this.components--;
            }

            public void addComponent(int p) {
                if (parent[p] > 0 && size[p] > 0) {
                    return;
                }

                parent[p] = p;
                size[p] = 1;
                this.components++;
            }

            public int getComponents() {
                return this.components;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}