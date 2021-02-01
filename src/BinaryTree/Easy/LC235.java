package BinaryTree.Easy;

import BinaryTree.TreeNode;

public class LC235 {

    public TreeNode LCABST(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val) {
            return LCABST(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return LCABST(root.right, p, q);
        }

        return root; // because if not both condition above, means one left, one right, which current is the LCA
    }


}
