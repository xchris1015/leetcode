package BinarySearch.medium;

import java.util.ArrayList;
import java.util.List;

public class ClosestPositionOfTarget {

    public List<Integer> closest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(0);
            return result;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                result.add(mid);
                return result;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        // this is for 1 or two, what is we want k
        if (Math.abs(nums[start] - target) == Math.abs(nums[end] - target)) {
            result.add(start);
            result.add(end);
        } else if (Math.abs(nums[start] - target) > Math.abs(nums[end] - target)) {
            result.add(end);
        } else {
            result.add(start);
        }

        return result;
    }




}
