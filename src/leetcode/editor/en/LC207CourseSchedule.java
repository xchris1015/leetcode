package leetcode.editor.en;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC207CourseSchedule{
    public static void main(String[] args) {
        Solution solution = new LC207CourseSchedule().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];

        Map<Integer, Set<Integer>> graph = constructGraph(numCourses, prerequisites);
        for (int i = 0 ; i < numCourses ; i++ ) {
            if (checkCycle(i, graph, visited, visiting)) {
                return false;// with cycle, not DAG
            }
        }

        for (int i = 0 ; i < numCourses ; i++ ) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private Map<Integer, Set<Integer>> constructGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0 ; i < numCourses ; i++ ) {
            graph.put(i, new HashSet<>());
        }

        for (int[] pre : prerequisites) {
            int preCourse = pre[1];
            int course = pre[0];

            Set<Integer> nextCourses = graph.getOrDefault(preCourse, new HashSet<>());
            nextCourses.add(course);
            graph.put(preCourse, nextCourses);
        }
        return graph;
    }

    private boolean checkCycle(int current, Map<Integer, Set<Integer>> graph, boolean[] visited, boolean[] visiting) {
        if (visiting[current]) {
            return true; //cycle
        }

        if (visited[current]) {
            return false; //no cycle and visited before
        }

        visiting[current] = true;
        Set<Integer> nextCourses = graph.getOrDefault(current, new HashSet<>());
        for (int next : nextCourses) {
            if (checkCycle(next, graph, visited, visiting)) {
                return true; // with cycle
            }
        }
        visited[current] = true;
        visiting[current] = false;

        return false;
    }


    /*
    DAG -> topo
    construct graph, key, currentCourse, value, pre-re
                    key -> int, value -> List<Integer> nextcourse if a course need more pre-re
                    Map<Integer, List<Integer>> or int[][] if size not change
    topo -> dfs/bfs

     */

}
//leetcode submit region end(Prohibit modification and deletion)

}