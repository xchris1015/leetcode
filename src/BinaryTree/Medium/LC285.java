package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.Stack;

public class LC285 {
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        if (root == null || p == null) {
//            return null;
//        }
//
//        TreeNode current = root;
//        TreeNode result = null;
//
//        while (current != null) {
//            if (current.val > p.val) {
//                result = current;
//                current = current.left;
//            } else {
//                current = current.right;
//            }
//        }
//
//        return result;
//    }

    // restrict Successor, need to check p exist in the tree
    // TODO use stack or prev and cur

    //binary tree Successor
    private TreeNode prev = null;
    private TreeNode result;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        result = root;
        dfs(root, p);
        return result;
    }

    private void dfs(TreeNode root, TreeNode p) {
         if (root == null) {
             return;
         }

         dfs(root.left, p);

         if (prev == p) {
             result = root;
             return;
         }

         prev = root;

         dfs(root.right, p);
    }

}
