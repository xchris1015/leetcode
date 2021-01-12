package InteviewI;

import BinaryTree.TreeNode;

public class LC450 {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        TreeNode cur = root;
        if (cur.val == key) {
            if (cur.left != null && cur.right != null) {
                // case 1: if both child, find smallest one to rightTree and assign to current, and then delete the smallest on right
                cur.val = findMin(cur.right).val;
                //cur.val = findMin(cur.right).val
                cur.right = deleteNode(cur.right, cur.val);
            } else {
                cur = cur.left != null ? cur.left : cur.right;
            }
        } else if (cur.val > key){
            // need to update left and right because the cur.left or right might change based on recusion, it
            // not just sample delete but with structure changes.
            cur.left = deleteNode(root.left, key);
        } else {
            cur.right = deleteNode(root.right, key);
        }


        return cur;
    }

    private TreeNode findMin(TreeNode root) {
        TreeNode cur = root;

        while (cur.left != null) {
            cur = cur.left;
        }

        return cur;
    }
}
