package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.Stack;

public class LC230 {

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        stack.push(current);
        while (!stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            if (--k == 0) return current.val;
            current = current.right;
        }

        return -1;
    }
}
