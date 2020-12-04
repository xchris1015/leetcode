package InteviewI;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC272 {

    //PriorityQueue

//    public List<Integer> closestKValues(TreeNode root, double target, int k) {
//
//        if (root == null) {
//            return new ArrayList<>();
//        }
//
//        PriorityQueue<TreeNode> pq = new PriorityQueue<>(k, new Comparator<TreeNode>() {
//            @Override
//            public int compare(TreeNode o1, TreeNode o2) {
//                double result = Math.abs(o1.val - target) - Math.abs(o2.val - target);
//
//                if (result == 0) {
//                    return 0;
//                } else if (result < 0) {
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//        });
//
//        inorder(root, pq, k);
//
//        List<Integer> result = new ArrayList<>();
//
//        while (!pq.isEmpty()) {
//            result.add(pq.poll().val);
//        }
//
//        return result;
//    }
//
//    private void inorder(TreeNode root, PriorityQueue<TreeNode> pq, int k) {
//        if (root == null) return;
//
//        inorder(root.left, pq, k);
//
//        if (pq.size() < k) {
//            pq.add(root);
//        } else {
//            pq.add(root);
//            pq.poll();
//        }
//
//        inorder(root.right, pq, k);
//    }

    // stack//TODO


}
