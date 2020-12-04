package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class LC98 {

    // top down
//    public boolean isValidBST(TreeNode root) {
//        return valid(root, null, null);
//    }
//
//    private boolean valid(TreeNode root, Integer lower, Integer upper) {
//        if (root == null) {
//            return true;
//        }
//
//        if (lower != null && root.val <= lower) {
//            return false;
//        }
//
//        if (upper != null && root.val >= upper) {
//            return false;
//        }
//
//        boolean left = valid(root.left, lower, root.val);
//        boolean right = valid(root.right, root.val, upper);
//
//        return left && right;
//    }

    // bottom up

    public boolean isValidBST(TreeNode root) {
        return valid(root) == null;
    }

    private int[] valid(TreeNode root) {
        int[] res = new int[2];

        if (root.left == null && root.right == null) {
            res[0] = root.val;
            res[1] = root.val;
            return res;
        }



        int[] left = valid(root.left);
        int[] right = valid(root.right);

        if (left == null || right == null) {
            return null;
        }

        if (root.val <= left[1] || root.val >= right[0]) {
            return null;
        }

        res[0] = left[0];
        res[1] = right[1];

        return res;
    }



    // prev global
//    public boolean isValidBST(TreeNode root) {
//        return valid(root);
//    }
//
//    private TreeNode prev = null;
//    private boolean valid(TreeNode root) {
//
//        if (root == null) {
//            return true;
//        }
//
//        if (!valid(root.left)) {
//            return false;
//        }
//
//        if (prev != null && root.val <= prev.val) {
//            return false;
//        }
//
//        prev = root;
//
//        if (!valid(root.right)) {
//            return false;
//        }
//
//        return true;
//    }
//
//    public boolean isValidBST(TreeNode root) {
//        TreeNode[] prev = new TreeNode[1];
//        prev[0] = null;
//        return valid(root, prev);
//    }
//
//    private boolean valid(TreeNode root, TreeNode[] prev) {
//
//        if (root == null) {
//            return true;
//        }
//
//        if (!valid(root.left, prev)) {
//            return false;
//        }
//
//        if (prev[0] != null && root.val <= prev[0].val) {
//            return false;
//        }
//        prev[0] = root;
//
//        if (!valid(root.right, prev)) {
//            return false;
//        }
//
//        return true;
//    }






}
