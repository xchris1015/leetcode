package BDFS.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17 {
    private static final Map<Character, String> NUMBERS = new HashMap<Character, String>(){{;
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        dfs(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void dfs(String digits, int currentDigits, StringBuilder path, List<String> result) {

        if (currentDigits == digits.length()) {
            result.add(path.toString());
            return;
        }

        String number = NUMBERS.get(digits.charAt(currentDigits));
        int length = path.length();
        for (int i = 0 ; i < number.length() ; i++ ) {
            path.append(number.charAt(i));
            dfs(digits, currentDigits + 1, path, result);
            path.setLength(length);
        }

    }
}
