package UnionFind;

import java.util.*;

public class LC721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return result;
        }

        Map<String, Integer> emailToUser = new HashMap<>();
        UnionFind uf = new UnionFind(accounts.size());

        for (int i = 0 ; i < accounts.size() ; i++ ) {
            List<String> account = accounts.get(i);
            for (int j = 1 ; j < account.size() ; j++ ) {
                String email = account.get(j);
                Integer id = emailToUser.get(email);

                if (id == null) {
                    emailToUser.put(email, i);
                } else {
                    if (!uf.find(id, i)) {
                        uf.union(id, i);
                    }
                }
            }
        }

        Map<Integer, Set<String>> userToEmail = new HashMap<>();

        for (int i = 0 ; i < accounts.size() ; i++ ) {
            Integer root = uf.root(i);

            if (!userToEmail.containsKey(root)) {
                userToEmail.put(root, new HashSet<String>());
            }

            for (int j = 1 ; j < accounts.get(i).size() ; j++ ) {
                userToEmail.get(root).add(accounts.get(i).get(j));
            }
        }

        for (Map.Entry<Integer, Set<String>> entry : userToEmail.entrySet()) {
            List<String> list = new LinkedList<>();

            list.addAll(entry.getValue());
            Collections.sort(list);
            list.add(0, accounts.get(entry.getKey()).get(0));
            result.add(list);
        }

        return result;
    }



    class UnionFind {

        private int[] parents;
        private int[] size;

        public UnionFind(int n) {
            parents = new int[n];
            size = new int[n];

            for (int i = 0 ; i < n ; i++ ) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public int root(int id) {
            int cur = id;

            while (cur != parents[cur]) {
                parents[cur] = parents[parents[cur]];
                cur = parents[cur];
            }

            parents[id] = cur;
            return cur;
        }

        public boolean find(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int pRoot = root(p);
            int qRoot = root(q);

            if (size[pRoot] > size[qRoot]) {
                parents[qRoot] = pRoot;
                size[pRoot] = qRoot;
            } else {
                parents[pRoot] = qRoot;
                size[qRoot] = pRoot;
            }
        }
    }
}
