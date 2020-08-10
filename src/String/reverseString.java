package String;

public class reverseString {

    public String reverseString(String string)  {

        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException();
        }

        int left = 0;
        int right = string.length() - 1;

        char[] chars =  string.toCharArray();

        helper(chars, left, right);

        return chars.toString();
    }

    private void helper(char[] chars, int left, int right) { //return type

        if (left >= right) {
            return;
        }

//        helper(chars, left + 1, right - 1);
//        swap(chars, left, right);


        swap(chars, left, right);
        helper(chars, left + 1, right - 1);
    }

    private void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }

}
