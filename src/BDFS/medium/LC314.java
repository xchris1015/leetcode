package BDFS.medium;

import BinaryTree.TreeNode;

import java.util.*;

public class LC314 {

    // BFS

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        queue.offer(new Node(0, root));

        int min = 0, max = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (!map.containsKey(current.col)) {
                map.put(current.col, new ArrayList<>());
            }

            map.get(current.col).add(current.node.val);

            if (current.node.left != null) {
                queue.offer(new Node(current.col - 1, current.node.left));
            }

            if (current.node.right != null) {
                queue.offer(new Node(current.col + 1, current.node.right));
            }

            min = Math.min(min, current.col);
            max = Math.max(max, current.col);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = min ; i <= max ; i++ ) {
            result.add(map.get(i));
        }

        return result;
    }

    class Node {
        int col;
        TreeNode node;

        public Node (int col, TreeNode node) {
            this.col = col;
            this.node = node;
        }
    }



}
