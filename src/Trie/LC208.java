package Trie;

public class LC208 {

    class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode (char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
    /** Initialize your data structure here. */

    private TrieNode root;

    public LC208() {
        this.root = new TrieNode('\0');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode current = root;

        for (Character c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode(c);
            }
            current = current.children[c - 'a'];
        }

        current.isWord = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;

        for (Character c : word.toCharArray()) {
            if (current.children[c - 'a'] != null) {
                current = current.children[c - 'a'];
            } else {
                return false;
            }
        }

        return current.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (Character c : prefix.toCharArray()) {
            if (current.children[c - 'a'] != null) {
                current = current.children[c - 'a'];
            } else {
                return false;
            }
        }

        return dfs(current);
    }

    private boolean dfs(TrieNode current) {
        if (current.isWord) {
            return true;
        }

        if (current == null) {
            return false;
        }

        for (int i = 0 ; i < current.children.length ; i++ ) {
            if (current.children[i] != null && dfs(current.children[i])) {
                return true;
            }
        }

        return false;
    }
}
