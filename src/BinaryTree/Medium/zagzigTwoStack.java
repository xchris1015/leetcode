package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class zagzigTwoStack {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        //BFS use two stack
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        boolean revert = false;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            Stack<TreeNode> stack = (revert) ? stack2 : stack1;
            int size = stack1.size();

            List<Integer> list = new ArrayList<>();

            for (int i = 0 ; i < size ; i++ ) {

                TreeNode current = stack1.pop();
                list.add(current.val);

                Stack<TreeNode> otherStack = (stack == stack1) ? stack2 : stack1;

                if (current.left != null) {
                    otherStack.push(current.left);
                }

                if (current.left != null) {
                    otherStack.push(current.right);
                }
            }

            result.add(list);
            revert = !revert;
        }

        return result;

    }

}
