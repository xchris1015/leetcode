package String.medium;

import java.util.Stack;

public class LC394 {

    public String decodeString(String s) {
        // use two stack, one for num, one for string
        // need to determine each scenrio
        // 1. number, need to add to val
        // 2. [, need to add an StringBuilder to accept strings
        // 3. ], need to times the next stringBuilder and add to top elements
        // 4. just character, add to peek

        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();

        int val = 0;
        strings.push(new StringBuilder());

        for (int i = 0 ; i < s.length() ; i++ ) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                val = val * 10 + (c - '0');
            } else if (c == '[') {
                strings.push(new StringBuilder());
                nums.push(val);
                val = 0;
            } else if (c == ']'){
                int count = nums.pop();
                StringBuilder sb = strings.pop();
                StringBuilder sbNext = new StringBuilder();

                while (count-- > 0) {
                    sbNext.append(sb);
                }
                strings.peek().append(sbNext);
            } else {
                strings.peek().append(c);
            }
        }

        return strings.pop().toString();
    }
}
