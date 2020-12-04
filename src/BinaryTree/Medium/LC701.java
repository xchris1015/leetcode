package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class LC701 {//TODO


    // idea insert the node:
    // use the properity of BST that,
    // case 1: val > root.val, go right
    // case 2: val < root.val, go left,
    // if if root.left == null, root.left = val, return root


    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root.left == null) {
            root.left = new TreeNode(val);
            return root;
        }

        if (val > root.val) {
            return insertIntoBST(root.right, val);
        } else {
            return insertIntoBST(root.left, val);
        }

    }
}
