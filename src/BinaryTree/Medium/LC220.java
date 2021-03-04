package BinaryTree.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class LC220 {

    // condition 1: nums[i] - nums[j] == t and i - j == k

//    private boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        if (nums == null || nums.length == 0) {
//            return false;
//        }
//
//        for (int i = k ; i < nums.length ; i++ ) {
//            if (nums[i] - nums[i - k] == t) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    // condition 2: nums[i] - nums[j] <= t and i - j == k

//    private boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        if (nums == null || nums.length == 0) {
//            return false;
//        }
//
//        for (int i = k ; i < nums.length ; i++ ) {
//            if (nums[i] - nums[i - k] <= t) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    // condition 3: nums[i] - nums[j] == t and i - j <= k
    //TODO have about duplicate?
    // use hashmap with count

    private boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++ ) {
            if (i > k) {
                Integer count = map.get(Long.valueOf(nums[i - k - 1]));

                if (count != null) {
                    count--;

                    if (count == 0) {
                        map.remove(Long.valueOf(nums[i - k - 1]));
                    } else {
                        map.put(Long.valueOf(nums[i - k - 1]), count);
                    }
                }
            }

            Long upper = (long)nums[i] + t;
            Long lower = (long)nums[i] - t;

            if (map.containsKey(upper) || map.containsKey(lower)) {
                return true;
            }

            Integer val = map.getOrDefault(Long.valueOf(nums[i]), 0);
            val++;
            map.put(Long.valueOf(nums[i]), val);
        }

        return false;
    }

    //Sliding window 应该先踢出去，不然如果先进来直接初结果就不符合题意了。
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        if (nums == null || nums.length == 0) {
//            return false;
//        }
//
//        TreeSet<Long> window = new TreeSet<>();
//
//        for (int i = 0 ; i < nums.length ; i++ ) {
//            if (i > k) {
//                window.remove(Long.valueOf(nums[i - k - 1]));
//            }
//
//            long upperBound = (long)nums[i] + t;
//            long lowerBound = (long)nums[i] - t;
//
//            Long val = window.floor(upperBound);
//
//            if (val != null && val >= lowerBound) {
//                return true;
//            }
//            window.add(Long.valueOf(nums[i]));
//        }
//
//        return false;
//    }



}
