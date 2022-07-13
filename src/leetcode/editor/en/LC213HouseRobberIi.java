package leetcode.editor.en;

public class LC213HouseRobberIi{
    public static void main(String[] args) {
        Solution solution = new LC213HouseRobberIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];

            return Math.max(maxProfit(nums, 0, nums.length - 1), maxProfit(nums, 1, nums.length));
        }

        private int maxProfit(int[] nums, int start, int end) {
            int t1 = 0;
            int t2 = 0;

            for (int i = start ; i < end ; i++ ) {
                int temp = t1;
                t1 = Math.max(nums[i] + t2, t1);
                t2 = temp;
            }

            return t1;
        }

    /*
    because cannot taken 0 and n, so divide problem to max profit of (0, n-1) and (1, n)
    */

        //TODO
}
//leetcode submit region end(Prohibit modification and deletion)

}