package BinaryTree.Easy;

import BinaryTree.TreeNode;

import java.util.TreeSet;

public class LC270 {

    //TreeMap closest

    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }

        TreeNode current = root;
        TreeNode closest = root;
        while (current != null) {
            if (current.val < target) {
                if (Math.abs(current.val - target) < Math.abs(closest.val - target)) {
                    closest = current;
                }
                current = current.left;
            } else if (current.val > target) {
                if (Math.abs(current.val - target) < Math.abs(closest.val - target)) {
                    closest = current;
                }
                current = current.right;
            } else {
                return current.val;
            }
        }

        return closest.val;
    }

    //TreeSet ceiling

    public int ceiling(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException();
        }

        TreeNode current = root;
        TreeNode ceiling = root;

        while (current != null) {
            if (current.val < target) {
                current = current.right;
            } else if (current.val > target) {
                ceiling = current;
                current = current.left;
            } else {
                return current.val;
            }
        }

        return ceiling.val >= root.val ? ceiling.val : root.val;
    }

    //TreeSet floor

    public int floor(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException();
        }

        TreeNode current = root;
        TreeNode floor = root;

        while (current != null) {
            if (current.val < target) {
                floor = current;
                current = current.right;
            } else if (current.val > target) {
                current = current.left;
            } else {
                return current.val;
            }
        }

        return floor.val;

    }

    //TreeSet lower


    //TreeSet higher


}
