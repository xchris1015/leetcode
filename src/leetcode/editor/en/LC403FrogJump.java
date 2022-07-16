package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class LC403FrogJump{
    public static void main(String[] args) {
        Solution solution = new LC403FrogJump().new Solution();
        // TO TEST
        int[] stones = new int[]{0,1,2,5,6,9,10,12,13,14,17,19,20,21,26,27,28,29,30};
        solution.canCross(stones);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /*
        search problem, branch, k - 1, k, k + 1 reachable stones

        pruning:
        idx, step -> boolean
        Map<step, boolean>[]
         */

    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }

        if (stones[1] - stones[0] != 1) return false;

        Map<Integer, Integer> positionToStone = new HashMap<>();
        Map<Integer, Boolean>[] memo = new HashMap[stones.length];
        for (int i = 0 ; i < stones.length ; i++ ) {
            positionToStone.put(stones[i], i);
            memo[i] = new HashMap<>();
        }
        return dfs(stones, 1, 1, positionToStone, memo);
    }

    private boolean dfs(int[] stones, int start, int prev, Map<Integer, Integer> positionToStone, Map<Integer, Boolean>[] memo) {
        if (start == stones.length - 1) {
            return true;
        }

        if (start > stones.length - 1) {
            return false;
        }

        Map<Integer, Boolean> map = memo[start];
        Boolean result = map.get(prev);
        if (result != null) {
            return result;
        }

        for (int k = prev - 1 ; k <= prev + 1 ; k++ ) {
            if (k <= 0) {
                continue;
            }
            int currentPosition = stones[start];
            int nextPosition = currentPosition + k;
            Integer nextStone = positionToStone.get(nextPosition);
            if (nextStone != null && dfs(stones, nextStone, k, positionToStone, memo)) {
                map.put(prev, true);
                return true;
            }
        }
        map.put(prev, false);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}