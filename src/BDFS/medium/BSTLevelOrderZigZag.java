package BDFS.medium;

import BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BSTLevelOrderZigZag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // use level %= 2 to define the order, and use Deque for two side in and out

        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            level %= 2;

            if (level % 2 == 0) {
                for (int i = 0 ; i < size ; i ++ ) {
                    TreeNode current = queue.pollFirst();
                    list.add(current.val);

                    if (current.left != null) {
                        queue.offerLast(current.left);
                    }

                    if (current.right != null) {
                        queue.offerLast(current.right);
                    }
                }
            } else {
                for (int i = 0 ; i < size ; i ++ ) {
                    TreeNode current = queue.pollLast();
                    list.add(current.val);
                    // Totally reverse the direction
                    if (current.right != null) {
                        queue.offerFirst(current.right);
                    }

                    if (current.left != null) {
                        queue.offerFirst(current.left);
                    }
                }
            }
            level++;
            result.add(list);
        }

        return result;
    }
}
