package String.easy;

public class LC796 {

    public boolean rotateString(String A, String B) {
        //cc

        // sample check and KMP

        return A.length() == B.length() && (A + A).contains(B);
    }
}
