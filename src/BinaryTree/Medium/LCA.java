package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }

    // what if k branch and m nodes? then m base case and k recursion call and check for nulls

    //LCA with BST

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {

        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);

        if (root.val > max) {
            return lowestCommonAncestorBST(root.left, p, q);
        } else if (root.val < min) {
            return lowestCommonAncestorBST(root.right, p, q);
        } else {
            return root;
        }

    }
}
