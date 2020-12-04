package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC95 {
    public List<TreeNode> generateTrees(int n) {

        if (n <= 0) {
            return new ArrayList<>();
        }

        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        if (start > end) {
            List<TreeNode> base = new ArrayList<>();
            base.add(null);
            return base;
        }

        List<TreeNode> result = new ArrayList<>();

        for (int i = start ; i <= end ; i++ ) {
            List<TreeNode> lefts = dfs(start, i - 1);
            List<TreeNode> rights = dfs(i + 1, end);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }
}
