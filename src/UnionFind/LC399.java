package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] result = new double[queries.size()];

        if (equations == null || values == null || queries == null) {
            return result;
        }

        UnionFind uf = new UnionFind();

        Map<String, Node> map = new HashMap<>();

        for (int i = 0 ; i < equations.size() ; i++ ) {
            String s1 = equations.get(i).get(0), s2 = equations.get(i).get(1);
            double v = values[i];

            if (!map.containsKey(s1)) map.put(s1, new Node(s1));
            if (!map.containsKey(s2)) map.put(s2, new Node(s2));

            Node v1 = map.get(s1);
            Node v2 = map.get(s2);

            if (!uf.find(v1, v2)) {
                uf.union(v1, v2, v);
            }
        }

        for (int i = 0 ; i < queries.size() ; i++ ) {
            String s1 = queries.get(i).get(0), s2 = queries.get(i).get(1);

            if (!map.containsKey(s1) || !map.containsKey(s2)) {
                result[i] = -1.0;
            } else {
                Node n1 = map.get(s1);
                Node n2 = map.get(s2);

                if (uf.find(n1, n2)) {
                    result[i] = uf.divide(n1, n2);
                } else {
                    result[i] = -1.0;
                }
            }
        }

        return result;

    }

    class Node {
        private String name;
        private double value;
        public Node parent;
        private int size;

        public Node(String name) {
            this.name = name;
            this.value = 1.0;
            this.parent = this;
            this.size = 1;
        }
    }

    class UnionFind {

        public UnionFind() {};

        public Node root(Node p) {
            Node cur = p;
            double d = 1.0;
            while (cur != cur.parent) {
                cur.value *= cur.parent.value;
                d *= cur.value;

                cur.parent = cur.parent.parent;
                cur = cur.parent;
            }

            p.parent = cur;
            p.value = d;
            return cur;
        }

        public boolean find(Node p, Node q) {
            return root(p) == root(q);
        }

        public void union(Node p, Node q, double d) {
            Node pRoot = root(p);
            Node qRoot = root(q);

            if (pRoot.size > qRoot.size) {
                qRoot.parent = pRoot;
                qRoot.value = (p.value * d) / q.value;
                pRoot.size += qRoot.size;
            } else {
                pRoot.parent = qRoot;
                pRoot.value = q.value / (p.value * d);
                qRoot.size += pRoot.size;
            }
        }

        public double divide(Node v1, Node v2) {
            return v2.value / v1.value;
        }
    }

    public static void main(String[] args) {
        LC399 lc = new LC399();
        List<List<String>> equations = new ArrayList<>();
        List<String> equa = new ArrayList<>();
        equa.add("a");
        equa.add("b");
        equations.add(equa);

        List<String> equa2 = new ArrayList<>();
        equa2.add("b");
        equa2.add("c");
        equations.add(equa2);

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        q1.add("a");
        q1.add("c");
        queries.add(q1);

        List<String> q2 = new ArrayList<>();
        q2.add("b");
        q2.add("a");
        queries.add(q2);

        lc.calcEquation(equations, values, queries);









    }
}
