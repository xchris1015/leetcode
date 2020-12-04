package TwoPointer;

public class LC424 {
    public int characterReplacement(String s, int k) {
        // counter
        int[] count = new int[256];
        int max = 0;
        char maxfreq = '\0';
        int start = 0;

        for (int end = 0 ; end < s.length() ; end++ ) {
            char c = s.charAt(end);
            count[c]++;

            if (count[c] > count[maxfreq]) {
                maxfreq = c;
            }

            while (end - start + 1 - count[maxfreq] > k) {
                char sc = s.charAt(start++);
                count[sc]--;

                if (sc == maxfreq) {
                    for (int i = 0 ; i < count.length ; i++ ) {
                        if (count[i] > count[maxfreq]) {
                            maxfreq = (char)i;
                        }
                    }
                }
            }

            max = Math.max(max, end - start + 1);
        }

        return max;

    }
}
