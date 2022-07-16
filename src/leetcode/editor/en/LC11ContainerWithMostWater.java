package leetcode.editor.en;

public class LC11ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new LC11ContainerWithMostWater().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /*
        two pointer, left and right, which is smaller, move toward center
         */
    public int maxArea(int[] height) {
        //cc

        int left = 0, right = height.length - 1, max = 0;

        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}