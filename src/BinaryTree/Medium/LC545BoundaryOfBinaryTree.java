package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC545BoundaryOfBinaryTree {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);

        leftBounary(root.left, list);
        leafNode(root.left, list);
        leafNode(root.right, list);
        rightBoundary(root.right, list);

        return list;
    }

    private void leftBounary(TreeNode root, List<Integer> list) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        list.add(root.val);

        if (root.left == null) {
            leftBounary(root.right, list);
        } else {
            leftBounary(root.left, list);
        }
    }

    private void rightBoundary(TreeNode root, List<Integer> list) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if (root.right == null) {
            rightBoundary(root.left, list);
        } else {
            rightBoundary(root.right, list);
        }
        list.add(root.val); // want the order reverse, add on the end
    }

    private void leafNode(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        leafNode(root.left, list);
        leafNode(root.right, list);
    }

}
