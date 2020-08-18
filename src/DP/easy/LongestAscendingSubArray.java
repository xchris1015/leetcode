package DP.easy;

public class LongestAscendingSubArray {

    public int longestSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int longest = 1;
        int current = 1;

        for (int i = 1 ; i < array.length ; i++ ) {

            if (array[i] > array[i - 1]) {
                current++;
            } else {
                current = 1;
            }

            longest = Math.max(longest, current);
        }

        return longest;
    }

    public String longestSubString(String string) {

        if (string == null || string.length() == 0) {
            return new String();
        }

        char[] chars = string.toCharArray();

        int slow = 1, fast = 1;
        int longest = 1;
        int left = 0, right = 0;

        // answer would be [s, f)

        for (fast = 1 ; fast < chars.length ; fast++ ) {

            if (chars[fast] > chars[fast - 1]) {
                slow = fast;
            }

            if (longest < fast - slow) {
                longest = fast - slow;
                left = slow;
                right = fast;
            }
        }

        return new String(chars, left, right - left);

    }




}
