package leetcode.editor.en;

import java.util.Stack;

public class LC20ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new LC20ValidParentheses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /*
        use stack to handle multiple case of parenthesis
         */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < s.length() ; i++ ) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.size() == 0) {
                    return false;
                }
                char ch = stack.peek();

                if (c == ')' && ch != '(') {
                     return false;
                } else if (c == ']' && ch != '[') {
                    return false;
                } else if (c == '}' && ch != '{') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.size() == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}