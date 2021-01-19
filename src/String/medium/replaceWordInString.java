package String.medium;

public class replaceWordInString {

    // replace get to access, which will increase the length,
    // we need to count how much get first and then buffer the space on the end
    // start with right side, this will avoid replace

    // similar idea with merge two sorted array into one (inplace, if the space is enough), we could start
    // both from the right side

    public String replaceWord(String s, String pattern, String replace) {

        //cc

        char[] chars = s.toCharArray();
        int count = 0;

        for (int i = 0 ; i < chars.length ; i++ ) {
           if (chars[i] == pattern.charAt(0) && checkSameWord(s, i, pattern)) {
               count++;
           }
        }

        int offset = (replace.length() - pattern.length()) * count;

        char[] result = new char[offset + s.length()];

        int slow = offset + s.length();

        for (int fast = chars.length ; fast >= 0 ; fast-- ) {
            if (chars[fast] == pattern.charAt(pattern.length() - 1) && checkSameWord(s, fast, pattern)) {
                replaceWord(result, fast, slow, chars);
            }
            result[slow] = chars[fast];
        }


        return result.toString();

    }

    public boolean checkSameWord(String s, int start, String pattern) {
        return true;
    }

    private void replaceWord(char[] result, int fast, int slow, char[] chars) {

    }

}
