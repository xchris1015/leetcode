package DFS.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || n < k) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        helper(n, k, 1, new ArrayList<>(), result);

        return result;
    }

    private void helper(int n, int k, int start, List<Integer> list, List<List<Integer>> result) {

        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start ; i <= n ; i++ ) {
            list.add(i);
            helper(n, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
