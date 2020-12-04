package BinarySearch.medium;

public class SearchInRotateArrayII {

    //bacause nums contain the duplicate element, we can check the element at the first stage, and then
    // if left or right still the same, move it to not same which update the range.

    //TODO

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {

            int mid = start + (end - start) / 2;

            if (nums[start] == target || nums[mid] == target || nums[end] == target) {
                return true;
            } else if (nums[start] == nums[mid]){
                while (nums[start] == nums[mid] && start < mid) {
                    start++;
                }
            } else if (nums[end] == nums[mid]) {
                while (nums[end] == nums[mid] && mid < end) {
                    end--;
                }
            } else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target || nums[end] == target) {
            return true;
        }

        return false;
    }
}
