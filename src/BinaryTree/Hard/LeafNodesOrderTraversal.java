package BinaryTree.Hard;

import BinaryTree.TreeNode;

import java.util.*;

public class LeafNodesOrderTraversal {

    public List<List<Integer>> leafNodes(TreeNode root) {

        // edge case
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        //idea : use getHeight to get every nodes's height and put same height together, can use hashmap to store
        // the height is from bottom to up

        Map<Integer, List<Integer>> levels = new HashMap<>();
        int leafLevel = Integer.MAX_VALUE;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int height = getHeight(current);
            if (!levels.containsKey(height)) {
                levels.put(height, new ArrayList<>());
            }
            List<Integer> heightList = levels.get(height);
            heightList.add(current.val);
            levels.put(height, heightList);
            // find max because we need the for loop on the end, root is the heightest level;
            leafLevel = Math.min(leafLevel, height);

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0 ; i < leafLevel ; i++) {
            result.add(levels.get(i));
        }

        return result;
    }

    private int getHeight(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int left = getHeight(current.left);
        int right = getHeight(current.right);

        return Math.max(left, right) + 1;
    }
}
