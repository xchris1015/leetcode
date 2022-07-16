package leetcode.editor.en;

import java.util.*;

public class LC269AlienDictionary{
    public static void main(String[] args) {
        Solution solution = new LC269AlienDictionary().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String alienOrder(String[] words) {
        //cc

        Map<Character, List<Character>> graph = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 0 ; i < words.length - 1 ; i++ ) {
            String current = words[i];
            String next = words[i + 1];

            if (current.length() > next.length() && current.startsWith(next)) {
                return "";
            }

            for (int j = 0; j < Math.min(current.length(), next.length()); j++) {
                char c = current.charAt(j);
                char n = next.charAt(j);

                if (c != n) {
                    List<Character> nextChar = graph.getOrDefault(c, new ArrayList<>());
                    nextChar.add(n);
                    graph.put(c, nextChar);
                    break;
                }
            }
        }

        boolean[] visited = new boolean[26];
        boolean[] visiting = new boolean[26];
        List<Character> list = new LinkedList<>();
        for (Character key : graph.keySet()) {
            if (checkCycle(key, graph, visited, visiting, list)) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean checkCycle(char current, Map<Character, List<Character>> graph, boolean[] visited, boolean[] visiting, List<Character> path) {
        int idx = current - 'a';
        if (visiting[idx]) {
            return true; // with cycle
        }

        if (visited[idx]) {
            return false;
        }

        visiting[idx] = true;
        List<Character> nexts = graph.getOrDefault(current, new ArrayList<>());
        for (char next : nexts) {
            if (checkCycle(next, graph, visited, visiting, path)) {
                return true; //with cycle
            }
        }

        path.add(0, current);
        visited[idx] = true;
        visiting[idx] = false;
        return false;
    }

    /*
    graph, directed, DAG -> topo
    construct graph: key character, value, next List<character>
                     map or List<Ineger>[], use map
    topo check cycle

     */
}
//leetcode submit region end(Prohibit modification and deletion)

}