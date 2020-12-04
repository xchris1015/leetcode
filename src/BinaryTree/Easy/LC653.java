package BinaryTree.Easy;

import BinaryTree.TreeNode;

import java.util.Stack;

public class LC653 {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> leftStack = initalLeftStack(root);
        Stack<TreeNode> rightStack = initalRightStack(root);

        while (true) {
            TreeNode left = leftStack.peek();
            TreeNode right = rightStack.peek();

            if (left == right) {
                break;
            }

            if (left.val + right.val < k) { // left++
                popLeftStack(leftStack);
            } else if (left.val + right.val > k) {
                popRightStack(rightStack);
            } else {
                return true;
            }
        }

        return false;
    }

    private void popRightStack(Stack<TreeNode> rightStack){

        TreeNode current = rightStack.pop().left;

        while (current != null) {
            rightStack.push(current);
            current = current.right;
        }

        return;

    }

    private void popLeftStack(Stack<TreeNode> leftStack){

        TreeNode current = leftStack.pop().right;

        while (current != null) {
            leftStack.push(current);
            current = current.left;
        }

        return;

    }

    private Stack<TreeNode> initalRightStack(TreeNode root) {

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null) {
            stack.push(current);
            current = current.right;
        }

        return stack;
    }

    private Stack<TreeNode> initalLeftStack(TreeNode root) {

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        return stack;
    }
}
