package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ValidCompleteTree {
    // S1 Global variable
    public boolean validCompleteTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean nullFlag = false;

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                nullFlag = true;
            } else {

                if (nullFlag) {
                    return false;
                }

                queue.offer(current.left);
                queue.offer(current.right);

            }
        }

        return true;
    }

    // S2

    //S3


}
