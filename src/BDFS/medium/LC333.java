package BDFS.medium;

import BinaryTree.TreeNode;

public class LC333 {

    public int largestBSTSubtree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        globalMax = 0;
        dfs(root);

        return globalMax;
    }

    private int globalMax;

    private Result dfs(TreeNode root) {

        if (root == null) {
            return new Result(0, 0, 0, true);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.isBST && (left.size == 0 || left.max < root.val) && right.isBST && (right.size == 0 || right.min > root.val)) {

            int size = left.size + right.size + 1;
            int min = left.size != 0 ? left.min : root.val;
            int max = right.max != 0 ? right.max : root.val;

            globalMax = Math.max(globalMax, size);

            return new Result (size, min, max, true);
        } else {
            return new Result(0, 0, 0, false);
        }

    }

    class Result {
        int size;
        int min;
        int max;
        boolean isBST;

        public Result (int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
}
