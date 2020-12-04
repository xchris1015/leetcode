package UnionFind;

import java.util.HashMap;

public class contryUnion {

    public int countCountryUnion(char[][] countries) {
        if (countries == null || countries.length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind();
        int max = 0;

        for (int i = 0 ; i < countries.length ; i++ ) {
            char[] country = countries[i];
            if (!uf.find(country[0], country[1])) {
                uf.union(country[0], country[1]);
            }
            max = Math.max(max, Math.max(uf.getSize(country[0]), uf.getSize(country[1])));
        }

        return max;

    }

    // clarify, do we know the country size?

    class UnionFind {

        private HashMap<Character, Character> parents;
        private HashMap<Character, Integer> sizes;

        public UnionFind () {
            this.parents = new HashMap<>();
            this.sizes = new HashMap<>();
        }

        public char root(char key) {
            char current = key;

            while (parents.get(current) != null && parents.get(current) != current) {
                Character grandParents = parents.get(parents.get(current));
                parents.put(current, grandParents);
                current = parents.get(current);
            }

            parents.put(key, current);
            return current;
        }

        public boolean find(char p, char q) {
            return parents.get(p) == parents.get(q);
        }

        public void union(char p, char q) {
            Character pRoot = root(p);
            Character qRoot = root(q);

            if (sizes.get(pRoot) > sizes.get(qRoot)) {
                parents.put(qRoot, pRoot);
                sizes.put(pRoot, sizes.get(pRoot) + sizes.get(qRoot));
            } else {
                parents.put(pRoot, qRoot);
                sizes.put(qRoot, sizes.get(pRoot) + sizes.get(qRoot));
            }
        }

        public int getSize(char key) {
            return sizes.get(key);
        }



    }




}
