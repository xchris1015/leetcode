package leetcode.editor.en;

import java.util.*;

public class LC721AccountsMerge{
    public static void main(String[] args) {
        Solution solution = new LC721AccountsMerge().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //TODO
    /*
    search problem in a graph, vertex, email, edge under same person, which share same user
    brute force:
    for each person idex, find same name, and shared email, if find, add email into graph, delete old one
    TC, n = number of name, k = ave number of email, O(NK)^2

    dfs: construct undirected graph by email address only, ONK
         for each user and start point, first email, dfs if not visited. ONK
         sort each list, logNK

    union find:
    user as vertex, map = map<email, user>
    while checking, if email => user exist, union user with current user
    create reverse mapping, user -> email by checking the root

    */

        class UnionFind {
            private int[] parent;
            private int[] size;

            public UnionFind (int n) {
                this.parent = new int[n];
                this.size = new int[n];

                for (int i = 0 ; i < n ; i++ ) {
                    parent[i] = i;
                    size[i] = 1;
                }
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
            }
        }

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            //cc

//         Map<String, Set<String>> graph = constructGraph(accounts);
//         List<List<String>> mergedAccount = new ArrayList<>();
//         Set<String> visited = new HashSet<>();
//         for (List<String> account : accounts) {
//             String name = account.get(0);
//             String startEmail = account.get(1);
//             List<String> currentList = new ArrayList<>();
//             if (!graph.containsKey(startEmail)) {
//                 currentList.add(name);
//                 mergedAccount.add(currentList);
//                 continue;
//             }

//             if (visited.contains(startEmail)) {
//                 continue;
//             }
//             dfs(startEmail, visited, currentList, graph);
//             Collections.sort(currentList);
//             currentList.add(0, name);
//             mergedAccount.add(currentList);
//         }

//         return mergedAccount;
            UnionFind uf = new UnionFind(accounts.size());
            Map<String, Integer> emailToUser = new HashMap<>();
            for (int j = 0 ; j < accounts.size() ; j++) {
                List<String> account = accounts.get(j);
                for (int i = 1 ; i < account.size() ; i++ ) {
                    String email = account.get(i);
                    if (!emailToUser.containsKey(email)) {
                        emailToUser.put(email, j);
                    } else {
                        uf.union(j, emailToUser.get(email));
                    }
                }
            }

            Map<Integer, List<String>> userToEmail = new HashMap<>();
            for (String email : emailToUser.keySet()) {
                int user = emailToUser.get(email);
                int rootUser = uf.getRoot(user);

                if (!userToEmail.containsKey(rootUser)) {
                    userToEmail.put(rootUser, new ArrayList<>());
                }
                userToEmail.get(rootUser).add(email);
            }

            List<List<String>> result = new ArrayList<>();
            for (Integer userIndex : userToEmail.keySet()) {
                List<String> emails = userToEmail.getOrDefault(userIndex, new ArrayList<>());
                Collections.sort(emails);
                String name = accounts.get(userIndex).get(0);
                emails.add(0, name);
                result.add(emails);
            }

            return result;
        }

//     private Map<String, Set<String>> constructGraph(List<List<String>> accounts) {
//         Map<String, Set<String>> graph = new HashMap<>();
//         for (List<String> account : accounts) {
//             String startEmail = account.get(1);

//             if (!graph.containsKey(startEmail)) {
//                 graph.put(startEmail, new HashSet<>());
//             }

//             for (int i = 2 ; i < account.size() ; i++ ) {
//                 String neigEmail = account.get(i);
//                 putIntoGraph(startEmail, graph, neigEmail);
//                 putIntoGraph(neigEmail, graph, startEmail);
//             }
//         }

//         return graph;
//     }

//     private void putIntoGraph(String email, Map<String, Set<String>> graph, String nextEmail) {
//             Set<String> neig = graph.getOrDefault(email, new HashSet<>());
//             neig.add(nextEmail);
//             graph.put(email, neig);
//     }

//     private void dfs(String cur, Set<String> visited, List<String> currentList, Map<String, Set<String>> graph) {

//         if (visited.contains(cur)) {
//             return;
//         }

//         currentList.add(cur);
//         visited.add(cur);

//         Set<String> nexts = graph.getOrDefault(cur, new HashSet<>());
//         for (String next : nexts) {
//             if (!visited.contains(next)) {
//                 dfs(next, visited, currentList, graph);
//             }
//         }
//     }
}
//leetcode submit region end(Prohibit modification and deletion)

}