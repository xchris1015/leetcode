package Trie;

public class LC211 {

    class TrieNode {
        private char val;
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode (char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = isWord;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public LC211() {
        this.root = new TrieNode('\0');
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (Character c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode(c);
            }
            current = current.children[c - 'a'];
        }

        current.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode current, int index) {
        if (word.length() == index && current.isWord) {
            return true;
        }

        if (current == null || index >= word.length()) {
            return false;
        }

        char ch = word.charAt(index);

        if (ch != '.') {
            if (current.children[ch - 'a'] != null && dfs(word, current.children[ch - 'a'], index + 1)) {
                return true;
            }
        } else {
            for (int i = 0 ; i < current.children.length ; i++) {
                if (current.children[i] != null && dfs(word, current.children[i], index + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}
