package DP.medium;

public class UnsortedArrayLargestSum {

    // S1: sort array, use binary search to find the point > 0, then linear sum the right part.
    // need to take care all < 0

    //S2: dp, pre possessing, find the overall sum for each index
    //    then, one pass the array, if sum[i] > 0, keep add, if not, record global sum, start new point,

    //On
//    public int findLargest(int[] array) {
//
//        if (array == null || array.length == 0) {
//            return 0;
//        }
//        int[] sum = new int[array.length];
//        sum[0] = array[0];
//
//        for (int i = 1 ; i < array.length ; i++ ) {
//            sum[i] = sum[i - 1] + array[i];
//        }
//
//        int globalMax = array[0];
//        for (int fast = 1 ; fast < sum.length ; fast++ ) {
//            if (sum[fast - 1] < 0) {
//                fast = array[fast];
//            }
//            globalMax = Math.max(globalMax, sum[fast]);
//        }
//
//        return globalMax;
//
//    }
    //O1
    public int findLargest(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }


        int current = array[0];
        int globalMax = array[0];
        for (int i = 1 ; i < array.length ; i++ ) {
            if (current < 0) {
                current = array[i];
            } else {
                current += array[i];
            }
            globalMax = Math.max(globalMax, current);
        }

        return globalMax;

    }



}
