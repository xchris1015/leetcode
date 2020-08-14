package String;

public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return new String("1");
        }

        String lastCount = countAndSay(n - 1);
        StringBuilder string = new StringBuilder();
        int i = 0;
        int count = 1; // because if the first one not equal to second one, we can still have first count
        while (i < lastCount.length()) {
            while (i < lastCount.length() - 1 && lastCount.charAt(i) == lastCount.charAt(i + 1)) {
                count++;
                i++;
            }
            string.append(Integer.toString(count));
            string.append(lastCount.charAt(i));
            i++;
            count = 1;
        }

        return string.toString();
    }

}
