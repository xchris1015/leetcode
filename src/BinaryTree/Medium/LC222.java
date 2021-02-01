package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class LC222 {

    // use the getHeight to get tree height, if the node pass
    // the middle line, means left is a full tree,
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1 + 1 + countNodes(root.right); // + 1 == root
        } else if (leftHeight > rightHeight) {
            return (int)Math.pow(2, rightHeight) - 1 + 1 + countNodes(root.left);
        }

        return 0;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode cur = root;
        int count = 0;
        while (cur != null) {
            cur = cur.left;
            count++;
        }

        return count;
    }
}
