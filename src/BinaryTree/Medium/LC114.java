package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class LC114 {
//    public void flatten(TreeNode root) {
//        dfs(root, null);
//    }
//
//    private TreeNode dfs(TreeNode root, TreeNode tail) {
//        if (root == null) {
//            return tail;
//        }
//
//        TreeNode right = dfs(root.right, tail);
//        TreeNode left = dfs(root.left, right);
//
//        root.right = left;
//        root.left = null;
//        return root;
//    }// keep move the left converted branch infront of the rigt branch

    // O1 space On time

    public void flatten(TreeNode root) {

        // Handle the null scenario
        if (root == null) {
            return;
        }

        TreeNode node = root;

        while (node != null) {

            // If the node has a left child
            if (node.left != null) {

                // Find the rightmost node
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // rewire the connections
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }

            // move on to the right side of the tree
            node = node.right;
        }
    }
}
