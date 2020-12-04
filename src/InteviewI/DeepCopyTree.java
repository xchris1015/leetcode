package InteviewI;

import BinaryTree.TreeNode;

public class DeepCopyTree {

    // use recursion
    public TreeNode cloneTree(TreeNode root) {

        if (root == null) return root;

        TreeNode left = cloneTree(root.left);
        TreeNode right = cloneTree(root.right);

        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = left;
        newRoot.right = right;

        return newRoot;

    }
}
