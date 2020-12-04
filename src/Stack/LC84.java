package Stack;

import java.util.Stack;

public class LC84 {

    public int largestRectangleArea(int[] heights) {
        // use minstack to keep the index with its value

        if (heights == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0 ; i <= heights.length ; i++ ) {
            int height = i == heights.length ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > height) {
                int idx = stack.pop();
                int area = heights[idx] * (stack.isEmpty() ? i : (i - stack.peek() - 1)); // stack.peek() == idx most left valid index
                max = Math.max(area, max);
            }

            stack.push(i);
        }

        return max;
    }
}
