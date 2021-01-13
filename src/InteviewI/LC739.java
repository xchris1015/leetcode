package InteviewI;

import java.util.Stack;

public class LC739 {

    public int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];

        if (T == null || T.length == 0) {
            return result;
        }

        Stack<Integer> stack = new Stack<>(); // with index

        for (int i = 0 ; i < result.length ; i++ ) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                result[stack.peek()] = i - stack.pop();
            }

            stack.push(i);
        }

        return result;
    }
}
