package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            if (current != null) {
                stack.push(current);
                result.add(current.val);
                current = current.left;
            } else {
                TreeNode top = stack.pop();
                current = top.right;
            }
        }

        return result;
    }
}
