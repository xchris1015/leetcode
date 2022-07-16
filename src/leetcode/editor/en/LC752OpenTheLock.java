package leetcode.editor.en;

import java.util.*;

public class LC752OpenTheLock{
    public static void main(String[] args) {
        Solution solution = new LC752OpenTheLock().new Solution();
        String[] deadends = {"0000"};

        solution.openLock(deadends, "8888");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();

        for (String s : deadends) {
            deads.add(s);
        }

        if (deads.contains("0000")) {
            return -1;
        }

        if (target.equals("0000")) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String current = queue.poll();
                List<String> nexts = getNexts(current);
                for (String next : nexts) {
                    if (next.equals(target)) {
                        return length + 1;
                    }

                    if (deads.contains(next) || visited.contains(next)) {
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

    private List<String> getNexts(String current) {
        char[] array = current.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i = 0 ; i < array.length ; i++ ) {
            char setback = array[i];
            for (int j = -1 ; j <= 1 ; j+=2 ) {
                int position = array[i] + j;
                if (position < '0' && array[i] == '0') {
                    array[i] = '9';
                } else if (position > '9' && array[i] == '9') {
                    array[i] = '0';
                } else {
                    array[i] = (char)position;
                }

                result.add(new String(array));
                array[i] = setback;
            }


        }

        return result;
    }

    /*
    search problem, branch '0' - '9' for each position,

    //TODO
    TC  SC n
     */
}
//leetcode submit region end(Prohibit modification and deletion)

}