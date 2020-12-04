package String.Hard;

public class RegexMatching {
    public boolean isMatch(String s, String p) {
        //everything is based on pattern but not the text
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // first part
        boolean firstMatch = s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // second part, if pattern after * can match the string ||
        //             * when first matches, much the rest of string with p
        //             * why this is valid
        //             p = a *, s = a a b
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) ||
                    firstMatch && isMatch(s.substring(1), p);
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
