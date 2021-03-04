package BinaryTree.Medium;

import java.util.Set;

public class LC211 {

    //TC O(k) for add, O(n*k) for search
    //if use hashset with dfs or bfs TC O(2^k) for add, search O(1)!!!1

//    private TrieNode root;
//    public LC211() {
//        this.root = new TrieNode('\0');
//    }
//
//    public void addWord(String word) {
//        if (word == null) {
//            return;
//        }
//        TrieNode cur = root;
//        for (int i = 0 ; i < word.length() ; i++ ) {
//            char ch = word.charAt(i);
//
//            if (cur.children[ch - 'a'] == null) {
//                cur.children[ch - 'a'] = new TrieNode(ch);
//            }
//            cur = cur.children[ch - 'a'];
//        }
//
//        cur.isWord = true;
//    }
//    // use dfs to search the word
//    public boolean search(String word) {
//        return dfs(word, 0, root);
//    }
//
//    private boolean dfs(String word, int index, TrieNode cur) {
//        if (cur == null) {
//            return false;
//        }
//
//        if (index == word.length()) {
//            return cur.isWord;
//        }
//
//        char c = word.charAt(index);
//
//        if (word.charAt(index) != '.') {
//            return dfs(word, index + 1, cur.children[c - 'a']);
//        } else {
//            for (TrieNode node : cur.children) {
//                if (node == null) {
//                    continue;
//                }
//
//                if (dfs(word, index + 1, node)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    class TrieNode {
//        private char ch;
//        private TrieNode[] children;
//        private boolean isWord;
//
//        public TrieNode(char ch) {
//            this.ch = ch;
//            this.children = new TrieNode[26];
//            this.isWord = false;
//        }
//    }

    //TODO hashSet and search

    private Set<String> dict;

    public void addWord(String input) {

        if (input == null || input.length() == 0) {
            return;
        }

        for (int i = 0 ; i < input.length() ; i++ ) {
            char ch = input.charAt(i);

            if (ch != '.') {

            }
        }

    }

    public boolean search(String input) {
        return dict.contains(input);
    }
}
