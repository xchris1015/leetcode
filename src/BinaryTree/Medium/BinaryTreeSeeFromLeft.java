package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.*;

public class BinaryTreeSeeFromLeft {

    Map<Integer, List<Integer>> levels = new HashMap<>();
    int maxSize = 0;
    public List<List<Integer>> seeFromLeft(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        //DFS with HashMap

        helper(root, 0);

        for (int i = 0 ; i < maxSize ; i++ ) {
            List<Integer> list = new ArrayList<>();

            for (Integer level : levels.keySet()) {
                list.add(levels.get(level).get(i));
            }
            result.add(list);
        }


        return result;
    }

    private void helper(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        if (!levels.containsKey(level)) {
            levels.put(level, new ArrayList<>());
        }

        List<Integer> list = levels.get(level);
        list.add(root.val);
        levels.put(level, list);

        maxSize = Math.max(maxSize, list.size());

        helper(root.left, level + 1);
        helper(root.right, level + 1);



    }



}
