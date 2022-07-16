package leetcode.editor.en;

public class LC10RegularExpressionMatching{
    public static void main(String[] args) {
        Solution solution = new LC10RegularExpressionMatching().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    dfs:
    search problem, branch: non-*, * (empty,a,aa,aaa,aaaa)
    note:
    base case
    TC: 2*n, SC, n

    */
//TODO not solved in 30 mins
        public boolean isMatch(String s, String p) {
            
            return true;

//            return dfs(s, 0, p, 0);
        }

        private boolean dfs(String s, int indexS, String p, int indexP) {
            if (p.length() == indexP) {
                return s.length() == indexS;
            }

            if (indexP == p.length() - 1 || p.charAt(indexP + 1) != '*') {
                if (indexS < s.length() && isMatch(s, indexS, p, indexP)) {
                    return dfs(s, indexS + 1, p, indexP + 1);
                } else {
                    return false;
                }
            } else {
                int i = indexS - 1;
                while (i < s.length() && (i == indexS - 1 || isMatch(s, i, p, indexP))) {
                    if (dfs(s, i + 1, p, indexP + 2)) {
                        return true;
                    }
                    i++;
                }

                return false;
            }
        }

        private boolean isMatch(String s, int indexS, String p, int indexP) {
            return p.charAt(indexP) == '.' ||s.charAt(indexS) == p.charAt(indexP);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}