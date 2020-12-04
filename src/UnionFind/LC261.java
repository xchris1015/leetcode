package UnionFind;

public class LC261 {

    public boolean validTree(int n, int[][] edges) {
        if (n != edges.length + 1) {
            return false;
        }

        UnionFind uf = new UnionFind(n);

        for (int[] e : edges) {
            int fromNode = e[0];
            int toNode = e[1];

            if (!uf.find(fromNode, toNode)) {
                uf.union(fromNode, toNode);
            } else {
                return false; //checkCycle
            }
        }

        return uf.size == 1;
    }

    class UnionFind {

        private int size;
        private int[] parents, nodeSize;

        public UnionFind (int n) {
            this.size = n;
            parents = new int[n];
            nodeSize = new int[n];

            for (int i = 0 ; i < n ; i++ ) {
                parents[i] = i;
                nodeSize[i] = 1;
            }
        }

        public int findRoot(int p) {

            int cur = p;
            while (parents[cur] != cur) {
                parents[cur] = parents[parents[cur]];
                cur = parents[cur];
            }

            parents[p] = cur;
            return cur;
        }

        public boolean find (int p, int q) {
            return findRoot(p) == findRoot(q);
        }

        public void union(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);

            if (nodeSize[pRoot] > nodeSize[qRoot]) {
                parents[qRoot] = pRoot;
                nodeSize[pRoot] += nodeSize[qRoot];
            } else {
                parents[pRoot] = qRoot;
                nodeSize[qRoot] += nodeSize[pRoot];
            }

            size--;
        }


    }
}
