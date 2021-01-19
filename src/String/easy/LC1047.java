package String.easy;

public class LC1047 {

    public String removeDuplicates(String S) {
        // use stack(StringBuilder), if peek == cur, then pop

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < S.length() ; i++ ) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == S.charAt(i)) {
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(S.charAt(i));
            }
        }

        return sb.toString();
    }
}
