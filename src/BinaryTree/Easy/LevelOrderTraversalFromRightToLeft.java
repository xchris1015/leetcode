package BinaryTree.Easy;


import BinaryTree.TreeNode;

import java.util.*;

public class LevelOrderTraversalFromRightToLeft {

    public List<List<Integer>> LevelOrderTraversalFromRightToLeft(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        //edge case
        if (root == null) {
            return result;
        }

        // BFS with queue
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0 ; i < size ; i++ ) {
                TreeNode current = queue.pollLast();
                list.add(current.val);

                if (current.left != null) {
                    queue.offerFirst(current.left);
                }

                if (current.right != null) {
                    queue.offerFirst(current.right);
                }
            }

            result.add(list);

        }

        return result;
    }
}
