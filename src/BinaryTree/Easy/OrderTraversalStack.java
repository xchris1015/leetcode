package BinaryTree.Easy;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OrderTraversalStack {

    public List<Integer> preinorder(TreeNode root) {
        //cc

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        List<Integer> result = new ArrayList<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                // result.add(cur.val); preorder, first time going into stack
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.peek();
                // result.add(top.val); inorder, first time out of stack
                cur = top.right;
            }
        }

        return result;
    }

    public List<Integer> preinpostorder(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();

            if (prev == null || prev.left == cur || prev.right == cur) {
                // result.add(cur.val) //preorder
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                    // result.add(cur.val) //inorder
                } else {
                    stack.pop();
                    // result.add(cur.val) // inorder/ postorder
                }
            } else if (prev == cur.left){
                // result.add(cur.val) //inorder
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    stack.pop();
                    // result.add(cur.val) // postorder
                }
            } else {
                stack.pop();
                // result.add(cur.val) // postorde;
            }
            prev = cur;
        }

        return result;
    }




}
