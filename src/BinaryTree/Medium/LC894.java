package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC894 {

    // similar to LC 95

    public List<TreeNode> allPossibleFBT(int N) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        return dfs(N, map);
    }

    // pattern, cannot handle n % 2 == 0 nodes

    private List<TreeNode> dfs(int n, Map<Integer, List<TreeNode>> cache) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        List<TreeNode> list = new ArrayList<>();

        if (n == 1) {
            list.add(new TreeNode(0));
            return list;
        }

        for (int i = 1 ; i < n ; i+=2 ) {
            List<TreeNode> left = dfs(i, cache);
            List<TreeNode> right = dfs(n - i - 1, cache); // root also a as part of n

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }

        cache.put(n, list);
        return list;
    }
}
