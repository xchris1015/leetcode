package BDFS.medium;
import java.util.*;

public class LC127 {
    // 08/31  11:09am
    // 11:32 do not know how to overwrite hashcode and equal function
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null) {
            throw new IllegalArgumentException("Input not valid");
        }

        Set<String> dict = new HashSet<>();

        for (String w : wordList) {
            dict.add(w);
        }

        return bfs(beginWord, endWord, dict);


    }

    private int bfs(String begin, String end, Set<String> dict) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        Set<String> visited = new HashSet<>();

        int minLength = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0 ; i < size ; i++ ) {
                String current = queue.poll();
                List<String> nextWords = findNextWords(current, dict);

                for (String next : nextWords) {

                    if (next.equals(end)) {
                        return minLength + 1;
                    }

                    if (!visited.contains(next)) {
                        queue.offer(next);
                    }
                }
            }
            minLength++;
        }

        return -1;
    }

    private List<String> findNextWords(String current, Set<String> dict) {

        List<String> list = new ArrayList<>();

        char[] word = current.toCharArray();

        for (int i = 0 ; i < word.length ; i++ ) {
            char temp = word[i];
            for (char j = 'a' ; j <= 'z' ; j++ ) {
                if (temp == j) {
                    continue;
                }

                word[i] = j;
                String next = new String(word);
                if (dict.contains(next)) {
                    list.add(next);
                }
            }
            word[i] = temp;
        }

        return list;
    }

    // Solution 2: 首尾相接， 双向BFS //TODO finish word Ladder 1
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//        if (beginWord == null || endWord == null) {
//            throw new IllegalArgumentException("Input not valid");
//        }
//
//        Set<String> dict = new HashSet<>();
//
//        for (String w : wordList) {
//            dict.add(w);
//        }
//
//        return bibfs(beginWord, endWord, dict);
//
//    }
//
//    private int bibfs(String beginWord, String endWord, Set<String> dict) {
//
//        HashSet<String> current = new HashSet<>();
//        HashSet<String> nextLevel = new HashSet<>();
//
//        current.add(beginWord);
//
//
//    }


    public static void main(String args[]) {

        String begin = "hit";
        String end = "cog";

        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("dot");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        LC127 lc = new LC127();
        lc.ladderLength(begin, end, wordList);



    }

}
