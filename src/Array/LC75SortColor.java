package Array;

public class LC75SortColor {

    //S1: bucket sort, if input have the range

    //S2: partition by two, first partition by 0 and > 0, second partition by <1 and > 1
//TODO

    //S3: Three pointer, left, right, cur, when cur <= right, cur is the one going for check and right is the boundary for the 2’s, if cur meets right, means all of the elements are checked.

    public void sortColors(int[] nums) {
        // for all idx < i : nums[idx < i] = 0
        // j is an index of element under consideration
        int p0 = 0, curr = 0;
        // for all idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // swap p0-th and curr-th elements
                // i++ and j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // swap k-th and curr-th elements
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }

}
