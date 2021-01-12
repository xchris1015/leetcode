package InteviewI;

public class StoneCut {

//    public int stoneCut(int[] cuts) {
//        if (cuts == null || cuts.length == 0) {
//            return 0;
//        }
//
//        return dfs(cuts, 0, cuts.length);
//    }
//
//    private int dfs(int[] cuts, int i, int j) {
//        if (i >= j) {
//            return 0;
//        }
//
//        int min = Integer.MAX_VALUE;
//
//        for (int k = i + 1 ; k < j ; k++ ) {
//            min = Math.min(min, cuts[j] - cuts[i] + Math.min(dfs(cuts, i, k), dfs(cuts, k, j)));
//        }
//
//        return min;
//    }

    public int stoneCut(int[] cuts) {
        if (cuts == null || cuts.length == 0) {
            return 0;
        }

        Integer[][] memo = new Integer[cuts.length][cuts.length];

        return dfs(cuts, 0, cuts.length, memo);
    }

    private int dfs(int[] cuts, int i, int j, Integer[][] memo) {
        if (i >= j) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i + 1 ; k < j ; k++ ) {
            min = Math.min(min, cuts[j] - cuts[i] + Math.min(dfs(cuts, i, k, memo), dfs(cuts, k, j, memo)));
        }

        memo[i][j] = min;
        return memo[i][j];
    }


}
