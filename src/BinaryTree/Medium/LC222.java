package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class LC222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getleftHeight(root.left);
        int right = getleftHeight(root.right);

        if (left == right) {
            return ((int)Math.pow(2, left)) - 1 + 1 + countNodes(root.right);
        } else if (left == right + 1) {
            return countNodes(root.left) - 1 + 1 + ((int)Math.pow(2, right));
        }

        return 0;
    }

    private int getleftHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        TreeNode cur = root;
        int count = 1;

        while (cur.left != null) {
            cur = cur.left;
            count++;
        }

        return count;
    }
}
