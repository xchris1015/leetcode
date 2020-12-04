package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class LC450 {

    // delete Node on BST

    // idea: recursion
    // 1. root == target, three cases:
    // 2. root < target, recursion to the right
    // 3. root > target, recursion to the left

    // case 1: left and right not null: get left largest or right smallest, replace current node value, then remove the node returned
    // case 2: left or right == null, return not null side
    // case 3: both null, return null

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            if (root.left != null && root.right != null) {
                root.val = findMin(root.right).val;
                root.right = deleteNode(root.right, root.val);
            } else {
                root = root.left != null ? root.left : root.right;
            }

        } else if (root.val < key){
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    private TreeNode findMin(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void main(String[] args) {






    }
}
