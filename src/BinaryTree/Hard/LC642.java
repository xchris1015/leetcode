package BinaryTree.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC642 {
    private TrieNode root, curNode;
    private HashMap<String, Integer> countBook;
    private StringBuilder sb;

    public LC642(String[] sentences, int[] times) {
        this.root = new TrieNode('\0');
        this.sb = new StringBuilder();
        for (int i = 0 ; i < sentences.length ; i++ ) {
            String word = sentences[i];
            Integer count = times[i];

            countBook.put(word, count);
            insertIntoTrie(word, count);
        }
        this.curNode = root;
    }

    public List<String> input(char c) {
        if (c == '#') {
            String word = this.sb.toString();
            int val = countBook.getOrDefault(word, 0);
            this.countBook.put(word, val + 1);
            insertIntoTrie(word, val + 1);
            this.sb.setLength(0);
            return new ArrayList<>();
        }

        this.sb.append(c);
        if (curNode == null) {
            return new ArrayList<>();
        }

        int idx = (c <= 'z' && c >= 'a') ? c - 'a' : 26;
        curNode = curNode.children[idx];
        if (curNode == null) {
            return new ArrayList<>();
        }
        return getTop3(curNode);
    }

    //TODO
    private List<String> getTop3(TrieNode curNode) {
        return new ArrayList<>();
    }

    private List<String> updateTop3(TrieNode curNode, String word, Integer count) {
        return new ArrayList<>();
    }

    private void insertIntoTrie(String word, int count) {
        TrieNode cur = this.root;
        for (char ch : word.toCharArray()) {
            int idx = (ch <= 'z' && ch >= 'a') ? ch - 'a' : 26;
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode(ch);
            }
            cur = cur.children[idx];
            updateTop3(cur, word, count);
        }
        cur.isWord = true;
    }

    class TrieNode {
        char ch;
        boolean isWord;
        HashMap<String, Integer> top3;
        TrieNode[] children;

        public TrieNode (char ch) {
            this.ch = ch;
            this.isWord = false;
            this.top3 = new HashMap<>();
            this.children = new TrieNode[27];
        }
    }

}
