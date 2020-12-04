package BDFS.hard;

import java.util.HashMap;
import java.util.Map;

public class LC403 {

    // without pruning

//    public boolean canCross(int[] stones) {
//        if (stones == null || stones.length == 0) {
//            return false;
//        }
//
//        return dfs(stones, 0, 0);
//    }
//
//    private boolean dfs(int[] stones, int start, int lastStep) {
//        if (start == stones.length - 1) {
//            return true;
//        }
//
//        if (start > stones.length) {
//            return false;
//        }
//
//        for (int next = start + 1 ; next < stones.length ; next++ ) {
//            int dis = stones[next] - stones[start];
//            if (dis < lastStep - 1) {
//                continue; // not valid step, can jump to next stone
//            } else if (dis > lastStep + 1) {
//                break; // unable to reach the next from this point;
//            } else { // because dis is > k - 1 and smaller than k + 1, also know as the dis to next, strickly use dis
//                if (dfs(stones, next, dis)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

    //pruning

    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }

        if (stones[1] - stones[0] != 1) return false;

        HashMap<Integer, Boolean>[] memo = new HashMap[stones.length];

        for (int i = 0 ; i < stones.length ; i++ ) {
            memo[i] = new HashMap<>();
        }

        return dfs(stones, 1, 1, memo);
    }

    private boolean dfs(int[] stones, int start, int lastStep, HashMap<Integer, Boolean>[] memo) {
        if (start == stones.length - 1) {
            return true;
        }

        HashMap<Integer, Boolean> map = memo[start];

        if (map.containsKey(lastStep)) {
            return map.get(lastStep);
        }

        for (int next = start + 1 ; next < stones.length ; next++ ) {
            int dis = stones[next] - stones[start];
            if (dis < lastStep - 1) {
                continue; // not valid step, can jump to next stone
            } else if (dis > lastStep + 1) {
                break; // unable to reach the next from this point;
            } else { // because dis is > k - 1 and smaller than k + 1, also know as the dis to next, strickly use dis
                if (dfs(stones, next, dis, memo)) {
                    map.put(lastStep, true);
                    return true;
                }
            }
        }
        map.put(lastStep, false);
        return false;
    }
}
