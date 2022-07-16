package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC364NestedListWeightSumIi{
    public static void main(String[] args) {
        Solution solution = new LC364NestedListWeightSumIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();

        for (NestedInteger nest : nestedList) {
            queue.offer(nest);
        }

        int sum = 0;
        int currentIntegerSum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int thisLevelSum = 0;
            while (size-- > 0) {
                NestedInteger current = queue.poll();

                if (current.isInteger()) {
                    thisLevelSum += current.getInteger();
                } else {
                    for (NestedInteger next : current.getList()) {
                        queue.offer(next);
                    }
                }
            }
            currentIntegerSum += thisLevelSum;
            sum += currentIntegerSum;
        }

        return sum;
    }

    class NestedInteger {
        boolean isInteger() {
            return true;
        }

        List<NestedInteger> getList() {
            return new ArrayList<>();
        }

        Integer getInteger() {
            return 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}