package leetcode.editor.en;

import java.util.*;

public class LC14LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new LC14LongestCommonPrefix().new Solution();
        // TO TEST
        String[] input = {"flower","flow","flight"};
        solution.longestCommonPrefix(input);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /*
        put into trie and start from root
        append each level until branches bigger than 1
         */

        class Trie {
            TrieNode root;

            public Trie() {
                this.root = new TrieNode('\0');
            }

            public void addWord(String s) {
                TrieNode current = root;
                for (int i = 0 ; i < s.length() ; i++ ) {
                    TrieNode node = current.neigb.get(s.charAt(i));
                    if (node == null) {
                        node = new TrieNode(s.charAt(i));
                        current.neigb.put(s.charAt(i), node);
                    }
                    node.count++;
                    current = node;
                }
            }

        }

        class TrieNode {
            private char val;
            private Map<Character, TrieNode> neigb;
            private int count;

            public TrieNode(char val) {
                this.val = val;
                this.neigb = new HashMap<>();
                this.count = 1;
            }

            //update hashcode and equal
        }
    public String longestCommonPrefix(String[] strs) {

        Trie trie = new Trie();
        for (String s : strs) {
            if (s.isEmpty()) {
                return "";
            }
            trie.addWord(s);
        }

        TrieNode current = trie.root;
        StringBuilder sb = new StringBuilder();
        while (current.neigb.size() == 1) {
            for (Map.Entry<Character, TrieNode> entry : current.neigb.entrySet()) {
                sb.append(entry.getKey());
                current = entry.getValue();
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}