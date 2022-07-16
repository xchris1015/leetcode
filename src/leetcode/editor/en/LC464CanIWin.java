package leetcode.editor.en;

public class LC464CanIWin{
    public static void main(String[] args) {
        Solution solution = new LC464CanIWin().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //TODO need to think about pruning with bit
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean[] pool = new boolean[maxChoosableInteger + 1];
        return dfs(desiredTotal, 0, pool);
    }

    private boolean dfs(int target, int sum, boolean[] pool) {
        if (sum >= target) {
            return false;
        }

        for (int i = 1 ; i < pool.length ; i++ ) {
            if (!pool[i]) {
                pool[i] = true;
                boolean nextResult = dfs(target, sum + i, pool);
                pool[i] = false;

                if (!nextResult) {
                    return true;
                }
            }
        }

        return false;
    }

    /*
    search problem, each player take available number, if next player cannot win, then he win
     */
}
//leetcode submit region end(Prohibit modification and deletion)

}