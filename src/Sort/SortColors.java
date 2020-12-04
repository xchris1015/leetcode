package Sort;

public class SortColors {

    //partition 2

//    public void sortColors(int[] nums) {
//        //    2 0 2 1 1 0
//        if (nums == null || nums.length == 0) {
//            return;
//        }
//
//        int i = 0, j = nums.length - 1;
//        int pivot = i + (j - i) / 2;
//        while (i < j) {
//            while (i < pivot && nums[i] == 0) {
//                i++;
//            }
//
//            while (j > pivot && nums[j] != 0) {
//                j--;
//            }
//
//            swap(nums, i, j);
//        }
//        int oneIndex = 0;
//        for (i = 0 ; i < nums.length ; i++ ) {
//            if (nums[i] != 0) {
//                oneIndex = i;
//                break;
//            }
//        }
//
//        i = oneIndex;
//        j = nums.length - 1;
//        pivot = i + (j - i) / 2;
//        while (i < j) {
//            while (i < pivot && nums[i] == 1) {
//                i++;
//            }
//
//            while (j > pivot && nums[j] == 2) {
//                j--;
//            }
//
//            swap(nums, i, j);
//        }
//
//    }
//
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // three pointer:
    //    0 0 2 1 1 2
    //      i
    //      j
    //            k

    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;

        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j = i;
            } else if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } else {
                j++;
            }
        }
    }


    public static void main(String[] args) {
        int[] input = {0, 2, 1};
        SortColors sor = new SortColors();
        sor.sortColors(input);
        for (int i = 0 ; i < input.length ; i++ ) {
            System.out.println(input[i]);
        }

    }
}
