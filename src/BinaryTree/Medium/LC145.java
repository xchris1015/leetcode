package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = null;
        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.peek();

            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    result.add(stack.pop().val);
                }
            } else if (prev == current.left) {
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    result.add(stack.pop().val);
                }
            } else {
                result.add(stack.pop().val);
            }
            prev = current;
        }

        return result;
    }
}
