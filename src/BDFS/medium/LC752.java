package BDFS.medium;

import java.util.*;

public class LC752 {

    public int openLock(String[] deadends, String target) {
        if (deadends == null || deadends.length == 0 || target == null) {
            return -1;
        }

        Set<String> dict = new HashSet<>();
        for (String s : deadends) {
            dict.add(s);
        }

        String begin = "0000";

        if (dict.contains(begin)) {
            return -1;
        }

        if (target.equals(begin)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String current = queue.poll();
                List<String> list = getNexts(current, dict);
                for (String next : list) {
                    if (next.equals(target)) {
                        return length + 1;
                    }

                    if (visited.contains(next)) {
                        continue;
                    }

                    queue.offer(next);
                    visited.add(next);
                }
            }
            length++;
        }

        return -1;
    }

    private List<String> getNexts(String current, Set<String> dict) {
        List<String> result = new ArrayList<>();
        char[] chars = current.toCharArray();

        for (int i = 0 ; i < chars.length ; i++ ) {
            char c = chars[i];

            for (int j = -1 ; j <= 1 ; j+=2 ) {
                chars[i] = (char) (c + j);

                if (chars[i] > '9') {
                    chars[i] = '0';
                }

                if (chars[i] < '0') {
                    chars[i] = '9';
                }

                String next = String.valueOf(chars);
                if (!dict.contains(next)) {
                    result.add(next);
                }
            }

            chars[i] = c;
        }

        return result;




    }
}
