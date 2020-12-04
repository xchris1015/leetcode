package Stack;

import java.util.Stack;

public class LC227 {

    // with lastValue
//    public int calculate(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//
//        // use prev and lastValue
//
//        int sum = 0;
//        int lastValue = 0;
//        int curValue = 0;
//        Character oprt = '+';
//
//        for (int i = 0 ; i < s.length() ; i++ ) {
//            Character c = s.charAt(i);
//
//            if (Character.isDigit(c)) {
//                curValue = curValue * 10 + c - '0';
//            }
//
//            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) {
//                if (oprt == '+' || oprt == '-') {
//                    sum += lastValue;
//                    lastValue = (oprt == '+') ? curValue : -curValue;
//                } else if (oprt == '*') {
//                    lastValue = lastValue * curValue;
//                } else if (oprt == '/') {
//                    lastValue = lastValue / curValue;
//                }
//                oprt = c;
//                curValue = 0;
//            }
//        }
//        sum += lastValue;
//        return sum;
//    }

    //stack

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int curValue = 0;
        char operation = '+';
        for (int i = 0 ; i < s.length() ; i++ ) {
            Character c = s.charAt(i);

            if (Character.isDigit(c)) {
                curValue = curValue * 10 + (c - '0');
            }

            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(curValue);
                } else if (operation == '-') {
                    stack.push(-curValue);
                } else if (operation == '*') {
                    stack.push(stack.pop() * curValue);
                } else if (operation == '/') {
                    stack.push(stack.pop() / curValue);
                }

                operation = c;
                curValue = 0;
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
