package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class MaxPathSumLeafToRoot {
    // leaf to root;
    int max;

    public int leafToRoot(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = leafToRoot(root.left);
        int right = leafToRoot(root.right);

        max = Math.max(Math.max(left, right) + root.val, max);

        return Math.max(left, right) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        max = root.val;
        leafToRoot(root);
        return max;
    }

    // any to root;

    public int anyToRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = anyToRoot(root.left);
        int right = anyToRoot(root.right);

        return Math.max(0, Math.max(left, right)) + root.val;
    }

    // leaf to leaf

    public int leafToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = leafToLeaf(root.left);
        int right = leafToLeaf(root.right);

        max = Math.max(max, left + right + root.val);

        return Math.max(left, right) + root.val;
    }

    // any to any!!!!!
    int maxValue;
    public int maxPathSumS1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxValue = root.val;
        helper(root);
        return maxValue;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        // any to root
        int anyToRoot = Math.max(root.val, Math.max(left, right) + root.val);
        int crossRoot = left + root.val + right;

        maxValue = Math.max(maxValue, Math.max(anyToRoot, crossRoot));
        return anyToRoot;
    }





}
