package leetcode.editor.en;

public class LC323NumberOfConnectedComponentsInAnUndirectedGraph{
    public static void main(String[] args) {
        Solution solution = new LC323NumberOfConnectedComponentsInAnUndirectedGraph().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //TODO
/*
    search problem in a graph,
    undirected
    dfs: for each vertex, search, per dfs, per find TC O V + E, V = n, E = n, n^2, sc, n
    unionfind: TC, n^2(logn), sc, V
    */

        //union find
        public int countComponents(int n, int[][] edges) {
            //cc
            UnionFind uf = new UnionFind(n + 1);
            for (int i = 1 ; i <= n ; i++ ) {
                uf.addComponent(i);
            }

            for (int[] edge : edges) {
                int x = edge[0], y = edge[1];
                if (!uf.find(x, y)) {
                    uf.union(x, y);
                }
            }

            return uf.getComponent();
        }

        class UnionFind {
            private int[] parent;
            private int[] size;
            private int numberOfComponent;

            public UnionFind(int n) {
                this.parent = new int[n + 1];
                this.size = new int[n + 1];
                this.numberOfComponent = 0;
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
                int rootQ = getRoot(q);
                int rootP = getRoot(p);

                if (size[rootQ] > size[rootP]) {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                } else {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                }
                this.numberOfComponent--;
            }

            public void addComponent(int p) {
                if (parent[p] > 0 && size[p] > 0) {
                    return;
                }

                parent[p] = p;
                size[p] = 1;
                this.numberOfComponent++;
            }

            public int getComponent() {
                return this.numberOfComponent;
            }

        }

        // dfs
//         Map<Integer, Set<Integer>> graph = constructGraph(n, edges);
//         int count = 0;
//         int[] status = new int[n];
//         for (int i = 0 ; i < n ; i++ ) {
//             if (status[i] == 0) {
//                 dfs(i, graph, status);
//                 count++;
//             }
//         }

//         return count;
//     }

//     private Map<Integer, Set<Integer>> constructGraph(int n, int[][] edges) {
//         Map<Integer, Set<Integer>> graph = new HashMap<>();

//         for (int i = 0 ; i < n ; i++ ) {
//             graph.put(i, new HashSet<>());
//         }

//         for (int[] edge : edges) {
//             int x = edge[0], y = edge[1];
//             Set<Integer> neigX = graph.getOrDefault(x, new HashSet<>());
//             neigX.add(y);
//             graph.put(x, neigX);
//             Set<Integer> neigY = graph.getOrDefault(y, new HashSet<>());
//             neigY.add(x);
//             graph.put(y, neigY);
//         }

//         return graph;
//     }

//     private void dfs(int cur, Map<Integer, Set<Integer>> graph, int[] status) {
//         status[cur] = 1;
//         Set<Integer> nexts = graph.getOrDefault(cur, new HashSet<>());
//         for (int next : nexts) {
//             if (status[next] == 1) {
//                 continue;
//             }
//             dfs(next, graph, status);
//         }
//     }
}
//leetcode submit region end(Prohibit modification and deletion)

}