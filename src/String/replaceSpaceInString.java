package String;

public class replaceSpaceInString {

    // give an string and a pattern and a word to replace, replace each element

    public int replaceBlank(char[] string, int length) {
        // write your code here
        if (string == null || string.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == ' ') {
                count++;
            }
        }
        int newLen = length + count * 2;

        for (int i = length - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                string[i + count * 2] = '0';
                string[i + count * 2 - 1] = '2';
                string[i + count * 2 - 2] = '%';
                count--;
            } else {
                string[i + count * 2] = string[i];
            }
        }
        return newLen;
    }


}
