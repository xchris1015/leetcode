package BDFS.medium;

import java.util.*;

public class WordLadderIII {

    private static void bfs(String beginWord, String endWord, List<String> listWord , Map<String, String> graph) {
        Set<String> dict = new HashSet<>();
        for (String w : listWord) {
            dict.add(w);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        dict.remove(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String current = queue.poll();

                for (String next : getNexts(current, dict)) {
                    if (next.equals(endWord)) {
                        graph.put(endWord, current);
                        break;
                    }

                    queue.offer(next);
                    dict.remove(next);
                    graph.put(next, current);
                }
            }
        }
        // throw exception
        return;
    }

    private static List<String> findPath(Map<String, String> graph, String beginWord, String endWord) {

        List<String> list = new ArrayList<>();
        list.add(endWord);
        String current = endWord;

        while (!current.equals(beginWord)) {
            String next = graph.get(current);
            list.add(0, next);
            current = next;
        }

        return list;
    }

    private static List<String> getNexts(String current, Set<String> dict) {
        char[] chars = current.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i = 0 ; i < chars.length ; i++ ) {
            for (char j = 'a' ; j <= 'z' ; j++ ) {
                if (current.charAt(i) == j) {
                    continue;
                }

                chars[i] = j;
                String next = String.valueOf(chars);
                if (dict.contains(next)) {
                    result.add(next);
                }
            }
            chars[i] = current.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "cog";

        List<String> listWord = Arrays.asList("hot","dot","dog","lot","log","cog");
        Map<String, String> graph = new HashMap<>();
        bfs(beginWord, endWord, listWord, graph);
        System.out.println(findPath(graph, beginWord, endWord));

    }
}
