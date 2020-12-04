package Stack;

import java.util.HashMap;
import java.util.Stack;

public class LC224 {

    // calculator +/-/()

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> nums = new Stack<>();
        Stack<Character> oprt = new Stack<>();
        oprtMap = new HashMap<>();
        oprtMap.put('+', 1);
        oprtMap.put('-', 1);

        int i = 0;

        handleOperator('(', nums, oprt);

        while (i < s.length()) {
            Character c = s.charAt(i);
            if (Character.isDigit(c)) {
                int val = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    int cur = (s.charAt(i) - '0');
                    val = val * 10 + cur;
                    i++;
                }
                nums.push(val);
            } else if (oprtMap.containsKey(c) || c == '(' || c == ')') {
                handleOperator(c, nums, oprt);
                i++;
            } else {
                i++;
            }
        }

        handleOperator(')', nums, oprt);

        return nums.peek();
    }

    private void handleOperator(Character c, Stack<Integer> nums, Stack<Character> oprt) {

        if (c == '(') {
            oprt.push(c);
        } else if (c == ')') {
            while (!oprt.isEmpty()) {
                Character curOprt = oprt.pop();

                if (curOprt == '(') {
                    break;
                }

                int nums2 = nums.pop();
                int nums1 = nums.pop();
                nums.push(calculate(nums1, nums2, curOprt));
            }
        } else { // if cur < stack.p{eek(), cal stack first
            while (!oprt.isEmpty()) {
                Character top = oprt.peek();

                if (oprtMap.containsKey(top) && greaterOrEqual(top, c)) {
                    Character curOprt = oprt.pop();
                    int nums2 = nums.pop();
                    int nums1 = nums.pop();
                    nums.push(calculate(nums1, nums2, curOprt));
                } else {
                    break;
                }
            }
            oprt.push(c);
        }
    }

    private HashMap<Character, Integer> oprtMap;

    private boolean greaterOrEqual(Character top, Character c) {
        return oprtMap.get(top) >= oprtMap.get(c);
    }

    private int calculate(int nums1, int nums2, Character oprt) {
        if (oprt == '+') {
            return nums1 + nums2;
        } else if (oprt == '-') {
            return nums1 - nums2;
        } else {
            return 0;
        }
    }
}
