package BDFS.hard;

import java.util.*;

public class LC126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // find the shortest path length using BFS
        // using dfs find the best path based on length

        if (beginWord == null || endWord == null) {
            return new ArrayList<>();
        }
        Set<String> dict = new HashSet<>();
        for (String w : wordList) {
            dict.add(w);
        }

        if (!dict.contains(endWord)) {
            return new ArrayList<>();
        }

        Map<String, List<String>> graph = new HashMap<>();
        List<List<String>> result = bfs(beginWord, endWord, dict, graph);

        return result;
    }

    private List<List<String>> bfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> graph) {
        List<List<String>> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean isEnd = false;
        int length = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            Set<String> thisLevelVisited = new HashSet<>();

            while (size-- > 0) {
                String current = queue.poll();

                List<String> l = getNexts(current, dict);
                for (String next : l) {
                    if (next.equals(endWord)) {
                        isEnd = true;
                    }

                    if (!thisLevelVisited.contains(next)) {
                        List<String> list = new ArrayList<>();
                        list.add(current);
                        graph.put(next, list);
                        queue.offer(next);
                        thisLevelVisited.add(next);
                    } else {
                        List<String> list = graph.get(next);
                        list.add(current);
                        graph.put(next, list);
                    }
                }
            }
            dict.removeAll(thisLevelVisited);

            if (isEnd) {
                List<String> path = new ArrayList<>();
                path.add(endWord);
                dfs(path, result, endWord, beginWord, graph);
                return result;
            }

            length++;
        }

        return result;
    }

    private void dfs(List<String> path, List<List<String>> result, String current, String endWord, Map<String, List<String>> graph) {
        if (current.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (String next : graph.get(current)) {
            path.add(0, next);
            dfs(path, result, next, endWord, graph);
            path.remove(0);
        }
    }

    private List<String> getNexts(String current, Set<String> dict) {
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



}
