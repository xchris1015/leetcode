package String.medium;

public class KeepKDuplicate {

    // a a a b b b c c d d
    //   s
    //       f

    // start with k's position
    // the result is [)
//    public String keepKDuplicate(String s, int k) {
//
//        if (s == null || s.length() == 0 || s.length() <= k) {
//            return s;
//        }
//
//        char[] chars = s.toCharArray();
//
//        int slow = k;
//
//        for (int fast = k ; k < s.length() ; k++ ) {
//            if (chars[fast] == chars[slow - k]) {
//                continue;
//            }
//
//            chars[slow++] = chars[fast];
//        }
//
//        return new String(chars, 0, slow);
//    }

    //TODO how about result is []

    //TODO how about  a b b b a c, which not sorted? need to use recusion, but what about base case? like about
    // if the length is equal

    //checkSUM, which use the hash the file, append to end, and then if the file has been changed,
    // then we could define if the file has been changed.

}
