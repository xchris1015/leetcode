package BinarySearch.hard;

public class FindMinimuminRotatedArrayII {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }


        int start = 0, end = nums.length - 1;

        if (nums[start] < nums[end]) return nums[start];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[start] == nums[mid]) {
                start++;
            } else if (nums[end] == nums[mid]) {
                end--;
            } else if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (nums[mid] > nums[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return nums[start] < nums[end] ? nums[start] : nums[end];

    }
}
