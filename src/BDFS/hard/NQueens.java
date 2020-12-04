package BDFS.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        if (n == 0) {
            return result;
        }

        helper(n, 0, new ArrayList<>(), result);

        return result;
    }

    private void helper(int size, int level, List<Integer> current, List<List<String>> result) {

        if (level >= size) {
            result.add(convert(current));
            return;
        }

        for (int i = 0 ; i < size ; i++ ) {

            if (isValid(current, level, i)) {
                current.add(i);
                helper(size, level + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> current, int level, int index) {
        if (current == null || current.size() == 0) {
            return true;
        }

        for (int i = 0 ; i < level ; i++ ) {
            if (current.get(i) == index || Math.abs(current.get(i) - index) == level - i) { //  current.get(i) == i level's j, level == level level's j, others are i's
                return false;
            }
        }

        return true;
    }

    private List<String> convert(List<Integer> current) {
        List<String> list = new ArrayList<>();

        for (int i  = 0 ; i < current.size() ; i++ ) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0 ; j < current.size() ; j++ ) {
                if (current.get(i) == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }

            }
            list.add(sb.toString());
        }
        return list;

    }




}
