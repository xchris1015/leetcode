package String.easy;

public class removeCharFromString {

    public String remove(String string, char target) {

        if (string == null || string.length() == 0) {
            return string;
        }

        int slow = 0;
        int fast;

        char[] chars = string.toCharArray();

        for (fast = 0 ; fast < chars.length ; fast++ ) {
            if (chars[fast] != target) {
                chars[slow++] = chars[fast];
            }
        }

        return new String(chars, 0, slow);

    }




}
