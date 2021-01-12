package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.*;

public class LC742 {

    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        constructGraph(graph, root, null);
        graph.remove(null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        for (TreeNode node : graph.keySet()) {
            if (node.val == k) {
                queue.offer(node);
                visited.add(node);
            }
        }

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current != null) {
                if (graph.get(current).size() <= 1) {// only connection is your parent
                    return current.val;
                }

                for (TreeNode nei : graph.getOrDefault(current, new ArrayList<>())) {

                    if (visited.contains(nei)) {
                        continue;
                    }

                    queue.offer(nei);
                    visited.add(nei);
                }

            }
        }

        return -1;
    }

    private void constructGraph(Map<TreeNode, List<TreeNode>> graph, TreeNode cur, TreeNode parent) {

        if (cur == null) {
            return;
        }

        if (!graph.containsKey(cur)) {
            graph.put(cur, new LinkedList<>());
        }

        if (!graph.containsKey(parent)) {
            graph.put(parent, new LinkedList<>());
        }

        graph.get(cur).add(parent);
        graph.get(parent).add(cur);

        constructGraph(graph, cur.left, cur);
        constructGraph(graph, cur.right, cur);


    }
}
