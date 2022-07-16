////////////<p>Given an array of integers <code>nums</code> sorted in non-decreasing order, find the starting and ending position of a given <code>target</code> value.</p>
////////////
////////////<p>If <code>target</code> is not found in the array, return <code>[-1, -1]</code>.</p>
////////////
////////////<p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>
////////////
////////////<p>&nbsp;</p>
////////////<p><strong>Example 1:</strong></p>
////////////<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 8
////////////<strong>Output:</strong> [3,4]
////////////</pre><p><strong>Example 2:</strong></p>
////////////<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 6
////////////<strong>Output:</strong> [-1,-1]
////////////</pre><p><strong>Example 3:</strong></p>
////////////<pre><strong>Input:</strong> nums = [], target = 0
////////////<strong>Output:</strong> [-1,-1]
////////////</pre>
////////////<p>&nbsp;</p>
////////////<p><strong>Constraints:</strong></p>
////////////
////////////<ul>
////////////	<li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
////////////	<li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li>
////////////	<li><code>nums</code> is a non-decreasing array.</li>
////////////	<li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li>
////////////</ul>
////////////<div><div>Related Topics</div><div><li>Array</li><li>Binary Search</li></div></div><br><div><li>👍 10153</li><li>👎 285</li></div>
    package leetcode.editor.en;
    public class FindFirstAndLastPositionOfElementInSortedArray {
        public static void main(String[] args) {
            Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
            int[] input = {5,7,7,8,8,10};
            solution.searchRange(input, 8);
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //cc
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        // find first position
        int first = findFirstPosition(nums, target);
        // find last position
        int last = findLastPosition(nums, target);

        if (first >= nums.length || last >= nums.length || nums[first] != target || nums[last] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{first, last};
    }

            private int findFirstPosition(int[] nums, int target) {
                int start = 0, end = nums.length - 1;

                while (start <= end) {
                    int mid = start + (end - start) / 2;

                    if (nums[mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

                return start;
            }

            private int findLastPosition(int[] nums, int target) {
                int start = 0, end = nums.length - 1;

                while (start <= end) {
                    int mid = start + (end - start) / 2;

                    if (nums[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }

                return end;
            }
}
//leetcode submit region end(Prohibit modification and deletion)

    }