package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class ConvertBinaryTreeToDoublyLinkedList {


    TreeNode prev = null;
    TreeNode head = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        inOrder(root);

        if (head != null && prev != null) {
            prev.right = head;
            head.left = prev;
        }

        return head;
    }

    private void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (prev != null) {
            prev.right = root;
        } else {
            head = root;
        }

        root.left = prev;

        prev = root;

        inOrder(root.right);
    }

    //TODO do it with Divide and Conquer

}
