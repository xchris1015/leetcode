package BinaryTree.Hard;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC272 {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        initalStack(leftStack, rightStack, root, target);

        while (k-- > 0) {

            if (!leftStack.isEmpty() && !rightStack.isEmpty()) {// always check empty
                TreeNode left = leftStack.peek();
                TreeNode right = rightStack.peek();

                if (Math.abs(left.val - target) <= Math.abs(right.val - target)) {
                    result.add(popLeftStack(leftStack));
                } else if (Math.abs(left.val - target) > Math.abs(right.val - target)) {
                    result.add(popRightStack(rightStack));
                }
            } else if (!leftStack.isEmpty()) {
                result.add(popLeftStack(leftStack));
            } else if (!rightStack.isEmpty()){
                result.add(popRightStack(rightStack));
            }
        }

        return result;

    }

    private Integer popLeftStack(Stack<TreeNode> stack) {

        TreeNode result = stack.pop();
        TreeNode current = result.left;

        while (current != null) {
            stack.push(current);
            current = current.right;
        }

        return result.val;

    }

    private Integer popRightStack(Stack<TreeNode> stack) {

        TreeNode result = stack.pop();
        TreeNode current = result.right;

        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        return result.val;

    }

    private void initalStack(Stack<TreeNode> left, Stack<TreeNode> right, TreeNode root, double target) {

        TreeNode current = root;

        while (current != null) {
            if (current.val < target) {
                left.push(current);
                current = current.right;
            } else {
                right.push(current);
                current = current.left;
            }
        }

        return;

    }
}
