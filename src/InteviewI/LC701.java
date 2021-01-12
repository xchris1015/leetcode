package InteviewI;

import BinaryTree.TreeNode;

public class LC701 {

    //S1: prev + cur

    public TreeNode insertTreeNode(TreeNode root, int val) {
        //cc

        TreeNode prev = null;
        TreeNode cur = root;

        while (cur != null) {
            prev = cur;
            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (prev.val < val) {
            prev.right = new TreeNode(val);
        } else {
            prev.left = new TreeNode(val);
        }

        return root;
    }


    // recusion

//    public TreeNode insertTreeNode(TreeNode root, int val) {
//        if (root == null) {
//            return new TreeNode(val);
//        }
//
//        if (root.val > val) {
//            root.left = insertTreeNode(root.left, val);
//        } else {
//            root.right = insertTreeNode(root.right, val);
//        }
//
//        return root;
//    }
}
