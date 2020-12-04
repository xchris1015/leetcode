package BDFS.medium;

import java.util.ArrayList;
import java.util.List;

public class LC282 {

    public List<String> addOperators(String num, int target) {
        // dfs, with three branch, and an calculator
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }

        if (num.equals("2147483648")) {
            return result;
        }

        dfs(num, 0, target, new StringBuilder(), result);
        return result;
    }

    private void dfs(String num, int idx, int target, StringBuilder path, List<String> result) {

        //success
        if (idx == num.length() && calculator(path) == target) {
            result.add(path.toString());
            return;
        }

        //fail
        if (idx == num.length()) {
            return;
        }

        int length = path.length();

        //inital

        int val = 0;
        for (int i = idx ; i < num.length() ; i++ ) {
            val = val * 10 + num.charAt(i) - '0';

            if (path.length() == 0) {
                path.append(val);
                dfs(num, i + 1, target, path, result);
                path.setLength(length);
            } else {
                //+
                path.append("+").append(val);
                dfs(num, i + 1, target, path, result);
                path.setLength(length);

                //-
                path.append("-").append(val);
                dfs(num, i + 1, target, path, result);
                path.setLength(length);

                //*
                path.append("*").append(val);
                dfs(num, i + 1, target, path, result);
                path.setLength(length);
            }

            if (val == 0) {
                break;
            }
        }

    }

    private int calculator(StringBuilder path) {
        //cc

        int sum = 0;
        int lastValue = 0;
        int currentValue = 0;
        char operation = '+';

        for (int i = 0 ; i < path.length() ; i++ ) {
            Character c = path.charAt(i);

            if (c != null && Character.isDigit(c)) {
                currentValue = currentValue * 10 + c - '0';
            }

            if (c != null && !Character.isDigit(c) && !Character.isWhitespace(c) || i == path.length() - 1) {
                if (operation == '+' || operation == '-') {
                    sum += lastValue;
                    lastValue = operation == '+' ? currentValue : -currentValue;
                } else if (operation == '*') {
                    lastValue = currentValue * lastValue;
                }

                operation = c;
                currentValue = 0;
            }
        }

        sum += lastValue;
        return sum;
    }
}
