package BinarySearch.medium;

import java.util.ArrayList;
import java.util.List;

public class KClosestPosition {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        if (arr == null || arr.length == 0 || k <= 0) {
            return result;
        }

        int position = findPosition(arr, x);

        result.add(arr[position]);

        addK(result, arr, k - 1, x, position);

        return result;
    }

    private int findPosition(int[] nums, int x) {
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == x) {
                return mid;
            } else if (nums[mid] > x) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return (Math.abs(nums[start] - x) <= Math.abs(nums[end] - x)) ? start : end;
    }

    private void addK(List<Integer> result, int[] nums, int count, int x, int position) {
        if (count == 0) {
            return;
        }

        int left = position - 1, right = position + 1;

        while (left >= 0 && right < nums.length && count > 0) {
            if (Math.abs(nums[left] - x) <= Math.abs(nums[right] - x)) {
                result.add(0, nums[left]);
                left--;
            } else {
                result.add(nums[right]);
                right++;
            }
            count--;
        }

        while (count > 0) {
            if (left < 0) {
                result.add(nums[right++]);
            } else {
                result.add(0, nums[left--]);
            }
            count--;
        }
    }
}
