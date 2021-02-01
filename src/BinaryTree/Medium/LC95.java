package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC95 {

    // need to careful for the base case, because start > end, we will return null
    // branch: each node could have n size of branch for each element
    // status: start, end
    // TC : n^n because n branch hight n

    // if ask for count, return count of numbers
    // able to do pruning because there is redudent calculation

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
