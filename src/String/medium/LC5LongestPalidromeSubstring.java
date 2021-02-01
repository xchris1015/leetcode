package String.medium;

public class LC5LongestPalidromeSubstring {

    // expand from the middle to see if there is an palidrome,
    // because we want the constant factor to be small, so check middle first, then if check mid - 1, mid + 1,
    // each check will check odd and even,
    // if we check from mid, we could pruning those operations have length < max

    public String LongestPalidromeSubString(String s) {

        //cc
        int start = 0, end = 0;
        for (int i = 0 ; i < s.length() - 1 ; i++ ) {
            int max1 = checkMaxPalidromeWithStart(s, i, i);
            int max2 = checkMaxPalidromeWithStart(s, i,i + 1);

            int localMax = Math.max(max1, max2);

            if (localMax > end - start + 1) {
                start = i - (localMax - 1) / 2;
                end = i + (localMax / 2);
            }

        }

        return s.substring(start, end + 1);
    }

    private int checkMaxPalidromeWithStart(String s, int left, int right) {

        int max = 0;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
        }

        return right - left - 1;

    }
}
