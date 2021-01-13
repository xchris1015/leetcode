package InteviewI;

import java.util.Stack;

public class LC87 {

    public int largestRectangleArea(int[] heights) {
        // primitive find left bound and right bound

        // advance, save the current heights, because if left look at right, find right, then from right to left, left is the right's left;

        //cc

        //TODO review advance algorithm

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0 ; i <= heights.length ; i++ ) {

            int height = i == heights.length ? 0 : heights[i];

            while (!stack.isEmpty() && height < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = i - (!stack.isEmpty() ? stack.peek() + 1 : 0);
                max = Math.max(max, h * w);
            }

            stack.push(i);
        }

        return max;
    }
}
