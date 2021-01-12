package BDFS.medium;

import BinaryTree.TreeNode;

public class LC298 {

    //bottom up

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] max = new int[1];

        dfs(root, max);
        return max[0];
    }

    private int dfs(TreeNode root, int[] max) {

        if (root == null) {
            return 0;
        }

        int left = dfs(root.left, max);
        int right = dfs(root.right, max);

        int result = 1;

        if (root.left != null && root.val + 1 == root.left.val) {
            result = Math.max(result, left + 1);
        }

        if (root.right != null && root.val + 1 == root.right.val) {
            result = Math.max(result, right + 1);
        }

        max[0] = Math.max(max[0], result);

        return result;
    }

    // top down

//    public int longestConsecutive(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int[] max = new int[1];
//
//        dfs(root, null, 0, max);
//        return max[0];
//    }
//
//    private void dfs(TreeNode root, TreeNode parent, int length, int[] max) {
//
//        if (root == null) {
//            return;
//        }
//
//        length = (parent != null && parent.val == root.val - 1) ? length + 1 : 1;
//
//        max[0] = Math.max(max[0], length);
//
//        dfs(root.left, root, length, max);
//        dfs(root.right, root, length, max);
//    }
}
