package InteviewI;

public class FirstMissingNumberLC41 {

    public int firstMissingPositive(int[] nums) {
        // because the result cannot bigger than nums.length,
        // for example, nums = [1, 2, 0];
        // swap each number to its position as sorted

        // A[A[i] - 1] ?= A[i], if not, swap those two number, with i-- to reconsider this position's element

        // for this problem, we only think about positive and nums[i] != i + 1(because index is 0 based)

        //cc

        for (int i = 0 ; i < nums.length ; i++ ) {
            if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length) {
                if (nums[i] == nums[nums[i] - 1]) {
                    continue;
                }

                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }

        for (int i = 0 ; i < nums.length ; i++ ) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
