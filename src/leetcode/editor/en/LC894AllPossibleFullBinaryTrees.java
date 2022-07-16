package leetcode.editor.en;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC894AllPossibleFullBinaryTrees{
    public static void main(String[] args) {
        Solution solution = new LC894AllPossibleFullBinaryTrees().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {//TODO think about pruning
    public List<TreeNode> allPossibleFBT(int n) {
        //cc
        Map<Integer, List<TreeNode>> memo = new HashMap<>();
        memo.put(0, new ArrayList<>());
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(0));
        memo.put(1, list);
        memo.put(2, new ArrayList<>());
        return dfs(n, memo);
    }

    private List<TreeNode> dfs(int n, Map<Integer, List<TreeNode>> memo) {
        List<TreeNode> list = memo.get(n);
        if (list != null) {
            return list;
        }

        List<TreeNode> result = new ArrayList<>();
        for (int i = 1 ; i < n ; i+=2 ) {
            List<TreeNode> lefts = dfs(i, memo);
            List<TreeNode> rights = dfs(n - i - 1, memo);

            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        memo.put(n, result);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}