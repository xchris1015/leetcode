package BDFS.medium;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        // check for each level if there is null and then we would not have any more elements on the next;


        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //flag
        boolean isNull = false;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                isNull = true;
            } else {
                if (isNull) {
                    return false;
                }
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        return true;
    }




}
