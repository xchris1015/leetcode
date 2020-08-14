package String.easy;

public class StrStr {

    public int strStr(String haystack, String needle) {

        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) {
            return -1;
        }

        for (int fast = 0 ; fast < haystack.length() - needle.length() + 1; fast++ ) {
            if (checkNeedle(haystack, needle, fast)) {
                return fast;
            }
        }

        return -1;
    }

    private boolean checkNeedle(String haystack, String needle, int start) {
        int i = start, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }

        return true;
    }

}
