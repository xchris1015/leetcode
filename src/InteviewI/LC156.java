package InteviewI;

import BinaryTree.TreeNode;

public class LC156 {
    // The original left child becomes the new root.
    // The original root becomes the new right child.
    // The original right child becomes the new left child.

    // do it for each left != null node
    public TreeNode upsideDownBinaryTree(TreeNode root) {

        if (root == null || root.left == null) {
            return root;
        }

        // get the new head from down side

        TreeNode newRoot = upsideDownBinaryTree(root.left);

        // update left and right based on three scenario

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newRoot;
    }

}
