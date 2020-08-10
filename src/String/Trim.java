package String;

public class Trim {

    // Trim :

    // idea : keep the first one, which is the one right after the word, fast and slow point, fast check for != blank

//    public String Trim(String string) {
//
//        if (string == null || string.length() == 0) {
//            return string;
//        }
//
//        int slow = 0;
//        int fast;
//
//        char[] chars = string.toCharArray();
//
//        for (fast = 0 ; fast < chars.length ; fast++ ) {
//            // fast == '' && fast - 1 == '', 0 is edge case
//            if (chars[fast] == ' ' && (fast == 0 || chars[fast - 1] == ' ')) {
//                continue;
//            }
//
//            chars[slow] = chars[fast];
//            slow++;
//        }
//
//        if (slow == 0) {
//            return new String();
//        }
//
//        return chars[slow - 1] == ' ' ? new String(chars, 0, slow - 1) : new String(chars, 0, slow);
//    }

    // idea : keep the last one, which is the one right before the word, fast and slow point, fast check for != blank
    //  y o u _ _ a r e _ g r e a t _ _
    //        f
    //      s
    public String Trim(String string) {

        if (string == null || string.length() == 0) {
            return string;
        }

        int slow = 0;
        int fast;

        char[] chars = string.toCharArray();

        for (fast = 0 ; fast < chars.length ; fast++ ) {

            if (chars[fast] == ' ' || (fast < chars.length && chars[fast + 1] == ' ')) {
                continue;
            }

            chars[slow] = chars[fast];
            slow++;
        }

        if (slow == 0) {
            return new String();
        }

        return chars[0] == ' ' ? new String(chars, 1, slow - 1) : new String(chars, 0, slow);
    }
}
