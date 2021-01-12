package InteviewI;

import BinaryTree.TreeNode;

public class LargestSmallerValueInBST {

    // max result one, min result zero

    TreeNode closest;

    public TreeNode findLargestInSmamller(TreeNode root, int target) {

        if (root == null) {
            return root;
        }

        closest = root;

        while (root != null) {
            if (root.val < target) {
                if (root.val > closest.val) {
                    closest = root;
                }
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return closest;

    }





}
