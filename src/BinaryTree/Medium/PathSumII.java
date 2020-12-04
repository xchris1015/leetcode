package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSumII(TreeNode root, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        helper(root, target, new ArrayList<>(), result);

        return result;
    }

    private void helper(TreeNode root, int leftSum, List<Integer> list, List<List<Integer>> result) {

        if (root == null ) { //TODO do not add leftSum < 0 because target could be negative!!!!
            return;
        }

        if (root.left == null && root.right == null && leftSum == root.val) {
            list.add(root.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1); //TODO most important part!!!!!
            return;
        }

        list.add(root.val);
        helper(root.left, leftSum - root.val, list, result);
        helper(root.right, leftSum - root.val, list, result);
        list.remove(list.size() - 1);
    }



}
