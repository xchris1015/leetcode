package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class zagzigWithThreeRows {

    public List<List<Integer>> zagzig(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // BFS with deque and flag

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 0;

        while (!deque.isEmpty()) {

            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            level %= 3;

            if (level != 0) {
                for (int i = 0 ; i < size ; i++ ) {
                    TreeNode current = deque.pollFirst();
                    list.add(current.val);

                    if (current.left != null) {
                        deque.offerLast(current.left);
                    }

                    if (current.right != null) {
                        deque.offerLast(current.right);
                    }
                }
            } else {
                for (int i = 0 ; i < size ; i++ ) {
                    TreeNode current = deque.pollLast();
                    list.add(current.val);

                    if (current.right != null) {
                        deque.offerFirst(current.right);
                    }

                    if (current.left != null) {
                        deque.offerFirst(current.left);
                    }
                }
            }
            level++;
            result.add(list);
        }

        return result;




    }



}
