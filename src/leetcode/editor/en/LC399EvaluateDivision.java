package leetcode.editor.en;

import java.util.*;

public class LC399EvaluateDivision{
    public static void main(String[] args) {
        Solution solution = new LC399EvaluateDivision().new Solution();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList(new String[]{"a", "b"}));
        equations.add(Arrays.asList(new String[]{"b", "c"}));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList(new String[]{"a", "c"}));
        queries.add(Arrays.asList(new String[]{"b", "a"}));
        queries.add(Arrays.asList(new String[]{"a", "e"}));
        queries.add(Arrays.asList(new String[]{"a", "a"}));
        queries.add(Arrays.asList(new String[]{"x", "x"}));
        solution.calcEquation(equations, values, queries);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //TODO
    /*
    search problem in
    //construct graph
    both directed graph a/b = 2.0 =>b/a = 0.5
    vertex, char, val = current relationship with neig

    dfs: hashmap<String, HashMap<String, value>>
    loop through and keep a value until find the target point, if all visited, return -1;
    TC: V+E, V = n, E = n / 2, k = length of query
    SC: M * N graph, visited, n

    union find:
    vertex : string, val to neig
    valuec = valuea / root / valueb / root
    */

        class Vertex {
            private String s;
            private double val;
            private Vertex parent;
            private int size;

            public Vertex(String s) {
                this.s = s;
                this.val = 1.0;
                this.parent = this;
                this.size = 1;
            }
        }

        class UnionFind {

            public UnionFind() {}

            public Vertex getRoot(Vertex p) {
                Vertex cur = p;
                double result = cur.val;
                while (cur.parent != cur) {
                    result *= cur.parent.val;
                    cur.val *= cur.parent.val;
                    cur.parent = cur.parent.parent;
                    cur = cur.parent;
                }
                p.parent = cur;
                p.val = result;
                return cur;
            }

            public boolean find(Vertex p, Vertex q) {
                return getRoot(p) == getRoot(q);
            }

            public void union(Vertex p, Vertex q, double value) {
                Vertex rootP = getRoot(p);
                Vertex rootQ = getRoot(q);

                if (rootP.size > rootQ.size) {
                    rootQ.parent = rootP;
                    rootQ.val = (p.val * value) / q.val;
                    rootP.size += rootQ.size;
                } else {
                    rootP.parent = rootQ;
                    rootP.val = q.val / (p.val * value);
                    rootQ.size += rootP.size;
                }
            }

            public double divide(Vertex p, Vertex q) {
                return q.val / p.val;
            }

            // p/q = x, rootP / rootQ = (rootP / p) * q / rootQ
        }

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            //cc
            Map<String, Vertex> mapping = new HashMap<>();
            UnionFind uf = new UnionFind();
            int index = 0;
            for (List<String> equation : equations) {
                String from = equation.get(0);
                String to = equation.get(1);
                double value = values[index++];

                if (mapping.get(from) == null) {
                    mapping.put(from, new Vertex(from));
                }

                if (mapping.get(to) == null) {
                    mapping.put(to, new Vertex(to));
                }

                Vertex v1 = mapping.get(from);
                Vertex v2 = mapping.get(to);

                if (!uf.find(v1, v2)) {
                    uf.union(v1, v2, value);
                }
            }

            index = 0;
            double[] result = new double[queries.size()];

            for (List<String> query : queries) {
                String from = query.get(0);
                String to = query.get(1);
                Vertex fromV = mapping.get(from);
                Vertex toV = mapping.get(to);

                if (fromV == null || toV == null) {
                    result[index++] = -1.0;
                    continue;
                }

                if (uf.find(fromV, toV)) {
                    result[index++] = uf.divide(fromV, toV);
                } else {
                    result[index++] = -1.0;
                }
            }

            return result;
        }
//         //cc

//         Map<String, Map<String, Double>> graph = constructGraph(equations, values);
//         double[] result = new double[queries.size()];
//         int index = 0;
//         for (List<String> query : queries) {
//             String from = query.get(0);
//             String to = query.get(1);

//             if (!graph.containsKey(from)) {
//                 result[index++] = -1.0;
//                 continue;
//             }

//             double[] val = new double[1];
//             if (dfs(graph, from, to, val, 1.0, new HashSet<>())) {
//                 result[index] = val[0];
//             } else {
//                 result[index] = -1.0;
//             }
//             index++;
//         }

//         return result;
//     }

//     private Map<String, Map<String, Double>> constructGraph(List<List<String>> equations, double[] values) {
//         Map<String, Map<String, Double>> graph = new HashMap<>();

//         for (int i = 0 ; i < equations.size() ; i++ ) {
//             String from = equations.get(i).get(0);
//             String to = equations.get(i).get(1);
//             putVertexIntoGraph(graph, from, to, values[i]);
//             putVertexIntoGraph(graph, to, from, 1.0 / values[i]);
//         }

//         return graph;
//     }

//     private void putVertexIntoGraph(Map<String, Map<String, Double>> graph, String from, String to, double value) {
//         Map<String, Double> toAndValue = graph.getOrDefault(from, new HashMap<>());
//         toAndValue.put(to, value);
//         graph.put(from, toAndValue);
//     }

//     private boolean dfs(Map<String, Map<String, Double>> graph, String cur, String target, double[] value, double carryValue, Set<String> visited) {
//         if (target.equals(cur)) {
//             value[0] = carryValue;
//             return true;
//         }

//         if (visited.contains(cur)) {
//             return false;
//         }

//         visited.add(cur);

//         Map<String, Double> neig = graph.getOrDefault(cur, new HashMap<>());
//         for (String next : neig.keySet()) {
//             if (dfs(graph, next, target, value, carryValue * neig.get(next), visited)) {
//                 return true;
//             }
//         }

//         visited.remove(cur);
//         return false;
//     }
}
//leetcode submit region end(Prohibit modification and deletion)

}