package TwoPointer;

public class LC340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // counter

        int[] count = new int[256];
        int ws = 0, start = 0, max = 0;
        for (int end = 0 ; end < s.length() ; end++ ) {
            char c = s.charAt(end);
            if (count[c]++ == 0) {
                ws++;
            }

            while (ws > k) {
                if (start <= end && --count[s.charAt(start++)] == 0) {
                    ws--;
                }
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
