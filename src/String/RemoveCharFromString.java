package String;

public class RemoveCharFromString {

    // S1: replace
//    [0, s)
//    (s,f)
//    (f, length)

//    public String remove(String string, char target) {
//
//        if (string == null || string.length() == 0) {
//            return new String();
//        }
//
//        char[] chars = string.toCharArray();
//
//        int slow = 0;
//
//        for (int i = 0 ; i < chars.length ; i++ ) {
//
//            if (chars[i] == target) {
//                chars[slow] = chars[i];
//                slow++;
//            }
//        }
//
//        return chars.toString();
//    }

    // same idea but swap
    public String remove(String string, char target) {


        if (string == null || string.length() == 0) {
            return new String();
        }

        char[] chars = string.toCharArray();

        int slow = 0;

        for (int i = 0 ; i < chars.length ; i++ ) {

            if (chars[i] == target) {
                swap(chars, slow, i);
                slow++;
            }
        }

        return chars.toString();
    }

    private void swap(char[] chars, int slow, int fast) {

        char temp = chars[slow];
        chars[slow] = chars[fast];
        chars[fast] = temp;
    }







}
