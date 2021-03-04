package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.Arrays;

public class LC298 {

//    public int findLength(TreeNode root) {
//
//        if (root == null) {
//            return 0;
//        }
//
//        dfs(root);
//        return globalMax;
//    }
//
//    private int globalMax = 0;
//
//    private int dfs(TreeNode root) {// the reason why we use globalMax, is this dfs means from root, from root to bottom the length,
//        // not for any root as root
//        if (root == null) {
//            return 0;
//        }
//
//        int left = dfs(root.left);
//        int right = dfs(root.right);
//
//        int val = 1;
//
//        if (root.left != null && root.val + 1 == root.left.val) {
//            val = Math.max(val, left + 1);
//        }
//
//        if (root.right != null && root.val + 1 == root.right.val) {
//            val = Math.max(val, right + 1);
//        }
//
//        globalMax  = Math.max(globalMax, val);
//
//        return val;
//    }

    // follow up: 带拐弯的，从下向上的也都算

    public int findLength(TreeNode root) {

        if (root == null) {
            return 0;
        }

        dfs(root);
        return globalMax;
    }

    private int globalMax = 0;

    private int[] dfs(TreeNode root) {// the reason why we use globalMax, is this dfs means from root, from root to bottom the length,
        // not for any root as root
        if (root == null) {
            return new int[2];
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] val = new int[2];
        Arrays.fill(val, 1);

        if (root.left != null) {
            if (root.left.val + 1 == root.val) {
                val[0] = Math.max(val[0], left[0] + 1);
            }
            if (root.left.val == root.val + 1) {
                val[1] = Math.max(val[1], left[1] + 1);
            }
        }

        if (root.right != null) {
            if (root.right.val + 1 == root.val) {
                val[0] = Math.max(val[0], right[0] + 1);
            }
            if (root.left.val == root.val + 1) {
                val[1] = Math.max(val[1], right[1] + 1);
            }
        }

        globalMax  = Math.max(globalMax, val[0]);
        globalMax  = Math.max(globalMax, val[1]);

        return val;
    }

}
