package BinaryTree.Easy;

import BinaryTree.TreeNode;

public class LC543 {

    // recusion, for every node, ask for left and right and + 1, then compare to globalMax
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        globalMax = 0;
        dfs(root);
        return globalMax - 1;
    }

    private int globalMax;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        globalMax = Math.max(globalMax, left + right + 1);

        return Math.max(left + 1, right + 1);
    }
}
