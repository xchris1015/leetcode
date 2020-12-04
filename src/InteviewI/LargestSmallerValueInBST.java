package InteviewI;

import BinaryTree.TreeNode;

public class LargestSmallerValueInBST {

    public TreeNode findLargestInSmamller(TreeNode root, int target) {

        if (root == null) {
            return root;
        }

        if (root.val >= target) {
            return findLargestInSmamller(root.left, target);
        } else {
            return findLargestInSmamller(root.right, target);
        }



    }



}
