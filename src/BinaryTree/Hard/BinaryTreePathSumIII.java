package BinaryTree.Hard;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSumIII {

    // Idea of this solution:
    // We need to traversal the entire tree by any order.
    // And then for each node, we need to do a dfs to find solutions for each node,
    // it is like a graph, we need a hash or an lastNode to prevent the route going backwards.

    class ParentTreeNode {
        public int val;
        public ParentTreeNode parent, left, right;
    }

    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        dfs(root, target, result);

        return result;
    }

    private void dfs(ParentTreeNode root, int target, List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        helper(root, target, result, new ArrayList<>(), null);

        dfs(root.left, target, result);
        dfs(root.right, target, result);

    }

    private void helper(ParentTreeNode root, int target, List<List<Integer>> result, List<Integer> current, ParentTreeNode lastNode) {

        current.add(root.val);
        target -= root.val;

        if (target == 0) {
            result.add(new ArrayList<>(current));
        }

        if (root.parent != null && lastNode != root.parent) {
            helper(root.parent, target, result, current, root);
        }

        if (root.left != null && lastNode != root.left) {
            helper(root.left, target, result, current, root);
        }

        if (root.right != null && lastNode != root.right) {
            helper(root.right, target, result, current, root);
        }

        current.remove(current.size() - 1);

    }
}

