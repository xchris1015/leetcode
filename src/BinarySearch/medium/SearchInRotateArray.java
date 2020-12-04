package BinarySearch.medium;

public class SearchInRotateArray {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && nums[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target <= nums[end] && nums[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;



    }

    //TODO, find the rotated index first and then compare the target to determine search which half
}
