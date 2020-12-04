package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NBTree {
    // only have two children, or 0 child.
    public List<TreeNode> NBTree(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0) {
            result.add(null);
            return result;
        }

        if (n == 1) {
            result.add(new TreeNode());
            return result;
        }
        // can only from 1 to n - 1, because if 0, or n, is does not match the requirement of two children or 0 child. 因为
        // 左右子树起码要有一个叶子，这样对于parent 才是两个child
        for (int l = 1 ; l < n ; l++ ) {
            List<TreeNode> lefts = NBTree(l - 1);
            List<TreeNode> rights = NBTree(n - l);

            for (TreeNode left : lefts) {
                for (TreeNode r : rights) {
                    TreeNode root = new TreeNode();
                    root.left = left;
                    root.right = r;
                    result.add(root);
                }
            }
        }

        return result;
    }
}
