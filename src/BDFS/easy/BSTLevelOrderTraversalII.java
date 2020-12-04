package BDFS.easy;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BSTLevelOrderTraversalII {

    List<List<Integer>> levels =  new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return levels;
        }

        traversal(root, 0);
        Collections.reverse(levels);
        return levels;
    }

    private void traversal(TreeNode root, int level) {
        if (level == levels.size()) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(root.val);

        if (root.left != null) {
            traversal(root.left, level + 1);
        }

        if (root.right != null) {
            traversal(root.right, level + 1);
        }
    }
}
