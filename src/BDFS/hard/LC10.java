package BDFS.hard;

public class LC10 {

    // dfs

//    public boolean isMatch(String s, String p) {
//        return dfs(s, 0, p, 0);
//    }
//
//    // idea, base case, three conditions: 1. p and s reach end, 2. p reach end, check s, 3. s reach end, check p, But s does not means anything,
//    // so we check p
//
//    private boolean dfs(String s, int idxS, String p, int idxP) {
//
//        int lenP = p.length(), lenS = s.length();
//
//        if (lenP == idxP) {
//            return lenS == idxS;
//        }
//
//        if (idxP == lenP - 1 || p.charAt(idxP + 1) != '*') { // not a*
//            if (idxS < lenS && (p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(idxS))) {
//                return dfs(s, idxS + 1, p, idxP + 1);
//            } else {
//                return false;
//            }
//        } else {
//            int i = idxS - 1; // because we need to match empty, for i + 1 = idxS, i == idxS - 1;
//
//            while (i < lenS && (i < idxS || p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(i))) {
//                if (dfs(s, i + 1, p, idxP + 2)) {
//                    return true;
//                }
//                i++;
//            }
//        }
//
//        return false;
//    }

    public boolean isMatch(String s, String p) {

        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1]; //

        return dfs(s, 0, p, 0, memo);
    }

    private boolean dfs(String s, int idxS, String p, int idxP, Boolean[][] memo) {

        int lenP = p.length(), lenS = s.length();

        if (lenP == idxP) {
            return lenS == idxS;
        }

        if (memo[idxS][idxP] != null) {
            return memo[idxS][idxP];
        }

        if (idxP == lenP - 1 || p.charAt(idxP + 1) != '*') { // not a*
            if (idxS < lenS && (p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(idxS))) {
                memo[idxS][idxP] = dfs(s, idxS + 1, p, idxP + 1, memo);
                return memo[idxS][idxP];
            } else {
                memo[idxS][idxP] = false;
                return memo[idxS][idxP];
            }
        } else {
            int i = idxS - 1; // because we need to match empty, for i + 1 = idxS, i == idxS - 1;
            while (i < lenS && (i < idxS || p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(i))) {
                if (dfs(s, i + 1, p, idxP + 2, memo)) {
                    memo[idxS][idxP] = true;
                    return memo[idxS][idxP];
                }
                i++;
            }
        }

        memo[idxS][idxP] = false;
        return memo[idxS][idxP];
    }


}
