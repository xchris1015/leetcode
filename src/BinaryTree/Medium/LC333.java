package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class LC333 {

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return globalMax;
    }

    private int globalMax = 0;

    private Result dfs(TreeNode root) {

        if (root == null) {
            return new Result(0, 0, 0, true);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.isBST && right.isBST && (left.size == 0 || left.max < root.val) && (right.size == 0 || right.min > root.val)) {
            // because we put false as 0 size, so we need to check this to add 1 as 1 node
            int size = left.size + right.size + 1;
            int min = left.size == 0 ? root.val : left.min;
            int max = right.size == 0 ? root.val : right.max;
            globalMax = Math.max(size, globalMax);
            return new Result(size, min, max, true);
        } else {
            // can use null
            return new Result(0, 0, 0, false);
        }

    }


    class Result {
        private int size;
        private int min;
        private int max;
        private boolean isBST;

        public Result (int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
}
