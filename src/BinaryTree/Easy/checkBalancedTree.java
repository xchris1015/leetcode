package BinaryTree.Easy;

import BinaryTree.TreeNode;

public class checkBalancedTree {
    // Solution 1: Nlogn
//    public boolean balancedTree(TreeNode root) {
//        if (root == null) return true;
//
//        int left = getHeight(root.left);
//        int right = getHeight(root.right);
//
//        return Math.abs(left - right) <= 1 && balancedTree(root.left) && balancedTree(root.right);
//    }
//
//    public int getHeight(TreeNode root) {
//        if (root == null) return 0;
//
//        int left = getHeight(root.left);
//        int right = getHeight(root.right);
//
//        return Math.max(left, right) + 1;
//    }

    //Solution 2 :
    // On //TODO need to check the video for the time complexity
    public boolean balancedTree(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }



}
