package leetcode.editor.en;

import java.util.*;

public class LC210CourseScheduleIi{
    public static void main(String[] args) {
        Solution solution = new LC210CourseScheduleIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            boolean[] visited = new boolean[numCourses];
            boolean[] visiting = new boolean[numCourses];
            int[] result = new int[numCourses];
            List<Integer> list = new LinkedList<>();
            Map<Integer, Set<Integer>> graph = constructGraph(numCourses, prerequisites);
            for (int i = 0 ; i < numCourses ; i++ ) {
                if (checkCycle(i, graph, visited, visiting, list)) {
                    return new int[]{};// with cycle, not DAG
                }
            }

            for (int i = 0 ; i < numCourses ; i++ ) {
                if (!visited[i]) {
                    return new int[]{};
                }
                result[i] = list.get(i);
            }

            return result;
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

        private boolean checkCycle(int current, Map<Integer, Set<Integer>> graph, boolean[] visited, boolean[] visiting, List<Integer> list) {
            if (visiting[current]) {
                return true; //cycle
            }

            if (visited[current]) {
                return false; //no cycle and visited before
            }

            visiting[current] = true;
            Set<Integer> nextCourses = graph.getOrDefault(current, new HashSet<>());
            for (int next : nextCourses) {
                if (checkCycle(next, graph, visited, visiting, list)) {
                    return true; // with cycle
                }
            }
            list.add(0, current);
            visited[current] = true;
            visiting[current] = false;
            return false;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}