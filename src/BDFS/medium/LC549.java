package BDFS.medium;

import BinaryTree.TreeNode;

public class LC549 {

    public int longestConsecutive(TreeNode root) {

        if (root == null) {
            return 0;
        }

        max = 0;
        dfs(root);
        return max;
    }

    private int max;

    private int[] dfs(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int decrease = 1, increase = 1;

        if (root.left != null) {
            if (root.left.val + 1 == root.val) {
                decrease = left[0] + 1;
            } else if (root.left.val - 1 == root.val) {
                increase = left[1] + 1;
            }
        }

        if (root.right != null) {
            if (root.right.val + 1 == root.val) {
                decrease = Math.max(right[0] + 1, decrease);
            } else if (root.right.val - 1 == root.val) {
                increase = Math.max(right[1] + 1, increase);
            }
        }

        max = Math.max(max, increase + decrease - 1);

        return new int[]{decrease, increase};

    }
}
