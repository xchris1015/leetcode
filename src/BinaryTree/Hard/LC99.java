package BinaryTree.Hard;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC99 {

    // find the two occurence, first time
    // 1 2 6 4 5 3 7
    //     x     y
    // inorder first, then first two values, finally swap
//    public void recoverTree(TreeNode root) {
//        //cc
//
//        List<Integer> nums = new ArrayList<>();
//        inorder(root, nums);
//        int[] swapValues = findValues(nums);
//        swap(root, 2, swapValues[0], swapValues[1]);
//    }
//
//    private void swap (TreeNode root, int count, int v1, int v2) {
//
//        if (root == null || count == 0) {
//            return;
//        }
//
//        if (root.val == v1 || root.val == v2) {
//            root.val = root.val == v1 ? v2 : v1;
//            count--;
//        }
//
//        swap(root.left, count, v1, v2);
//        swap(root.right, count, v1, v2);
//
//
//    }
//
//    private int[] findValues (List<Integer> nums) {
//
//        int first = -1, second = -1;
//
//        for (int i = 0 ; i < nums.size() - 1 ; i++ ) {
//            if (nums.get(i + 1) < nums.get(i)) {
//                second = nums.get(i + 1);
//
//                if (first == -1) first = nums.get(i);
//            }
//        }
//
//        return new int[]{first, second};
//
//    }
//
//    private void inorder(TreeNode root, List<Integer> nums) {
//        if (root == null) {
//            return;
//        }
//
//        inorder(root.left, nums);
//
//        nums.add(root.val);
//
//        inorder(root.right, nums);
//    }

    // use inorder to find the spot

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode[] mistake = new TreeNode[2];
        TreeNode[] prev = new TreeNode[1];

        dfs(root, mistake, prev);
        swap(mistake);
    }

    private void swap(TreeNode[] mistake) {
        if (mistake[0] == null || mistake[1] == null) {
            return;
        }

        int temp = mistake[0].val;
        mistake[0].val = mistake[1].val;
        mistake[1].val = temp;
    }

    private void dfs(TreeNode root, TreeNode[] mistake, TreeNode[] prev) {

        if (root == null) {
            return;
        }

        dfs(root.left, mistake, prev);

        if (prev[0] != null && prev[0].val > root.val) {
            mistake[1] = root;

            if (mistake[0] == null) mistake[0] = prev[0];
        }

        prev[0] = root;

        dfs(root.right, mistake, prev);

    }
}
