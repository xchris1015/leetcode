package Array.Medium;

public class RemoveDuplicateInSortedArray {

    // a a a b b b c c c
    //       f
    //   s

//    public String removeDuplicates(String string) { //TODO generic
//        // edge case
//        if (string == null || string.length() == 0) {
//            return new String();
//        }
//
//        // base case
//        if (string.length() == 1) {
//            return string;
//        }
//
//        char[] chars = string.toCharArray();
//        int slow = 1;
//        int fast;
//
//        for (fast = 1 ; fast < chars.length ; fast++ ) {
//
//            if (chars[fast] == chars[slow - 1]) {
//                continue;
//            }
//
//            chars[slow++] = chars[fast];
//        }
//
//        return new String(chars, 0, slow);
//
//    }

//    public String removeDuplicatesHoldK(String string, int k) { //TODO generic
//        // edge case
//        if (string == null || string.length() == 0) {
//            return new String();
//        }
//
//        // base case
//        if (string.length() <= k) {
//            return string;
//        }
//
//        char[] chars = string.toCharArray();
//        int slow = k;
//        int fast;
//
//        for (fast = k ; fast < chars.length ; fast++ ) {
//
//            if (chars[fast] == chars[slow - k]) {
//                continue;
//            }
//
//            chars[slow++] = chars[fast];
//        }
//
//        return new String(chars, 0, slow);
//
//    }

    //[0, s] approach

//    public String removeDuplicatesHoldK(String string, int k) { //TODO generic
//        // edge case
//        if (string == null || string.length() == 0) {
//            return new String();
//        }
//
//        // base case
//        if (string.length() <= k) {
//            return string;
//        }
//
//        char[] chars = string.toCharArray();
//        int slow = k - 1;
//        int fast;
//
//        for (fast = k ; fast < chars.length ; fast++ ) {
//
//            if (chars[fast] == chars[slow - k + 1]) {
//                continue;
//            }
//
//            chars[++slow] = chars[fast];
//        }
//
//        return new String(chars, 0, slow + 1);
//
//    }






}
