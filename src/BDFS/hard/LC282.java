package BDFS.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC282 {
    public static List<String> addOperators(String num, int target) {

        if (num == null || num.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        dfs(num, target, 0, new StringBuilder(), result);
        return result;


    }

    private static void dfs(String num, int target, int index, StringBuilder sb, List<String> result) {
        if (index == num.length()) {
            if (evaluate(sb.toString(), target)) {
                result.add(sb.toString());
            }
            return;
        }

        int val = 0;

        for (int i = index ; i < num.length() ; i++ ) {
            val = val * 10 + (num.charAt(i) - '0');
            int length = sb.length();
            if (sb.length() == 0) {
                sb.append(val);
                dfs(num, target, i + 1, sb, result);
                sb.setLength(length);
                continue;
            }

            sb.append('+').append(val);
            dfs(num, target, i + 1, sb, result);
            sb.setLength(length);

            sb.append('-').append(val);
            dfs(num, target, i + 1, sb, result);
            sb.setLength(length);

            sb.append('*').append(val);
            dfs(num, target, i + 1, sb, result);
            sb.setLength(length);
        }
    }



    private static boolean evaluate(String s, int target) {

        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';

        for (int i = 0 ; i < s.length() ; i++ ) {
            char current = s.charAt(i);

            if (Character.isDigit(current)) {
                currentNumber = currentNumber * 10 + (current - '0');
            }

            if (!Character.isDigit(current) && !Character.isWhitespace(current) || i == s.length() - 1) {

                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }

                operation = current;
                currentNumber = 0;
            }
        }

        while (!stack.isEmpty()) {
            target -= stack.pop();
        }

        return target == 0;

    }

    public static void main(String args[]) {
        addOperators("105", 5);

    }
}
