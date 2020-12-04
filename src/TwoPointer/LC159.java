package TwoPointer;

public class LC159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //e c e b a
        //s
        //e

        //ds1, ds2, dsidx1, dsidx2

        //cc
        char ds1 = '\0', ds2 = '\0';
        int start = 0, dsidx1 = -1, dsidx2 = -1, max = 0;

        for (int end = 0 ; end < s.length() ; end++ ) {
            char c = s.charAt(end);
            if (c == ds1) {
                dsidx1 = end;
            } else if (c == ds2) {
                dsidx2 = end;
            } else {
                if (dsidx1 < dsidx2) {
                    start = dsidx1 + 1;
                    ds1 = c;
                    dsidx1 = end;
                } else {
                    start = dsidx2 + 1;
                    ds2 = c;
                    dsidx2 = end;
                }
            }
            max = Math.max(max, end - start + 1);
        }

        return max;


    }
}
