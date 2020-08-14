package String;

public class rotateString {

    public void rotate(String s, int offset) {

        if (s == null || s.length() == 0) {
            return;
        }

        offset %= s.length();

        char[] chars = s.toCharArray();

        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, offset - 1);
        reverse(chars, offset, chars.length - 1);
    }

    private void reverse(char[] chars, int i, int j) {

        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
