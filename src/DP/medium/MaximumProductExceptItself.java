package DP.medium;

import java.util.HashSet;

public class MaximumProductExceptItself {

//    public int MaxExceptItself(int[] array) {
//
//        if (array == null || array.length == 0) {
//            return 0;
//        }
//
//        //Math, product all and then divide itself, need to care about how many zeros
//        HashSet<Integer> hashSet = new HashSet<>();
//        // pre-possessing for 0 indexes;
//        // and product with out 0;
//        int overallMax = 1;
//        for (int i = 0 ; i < array.length ; i++ ) {
//            if (array[i] == 0) {
//                hashSet.add(i);
//                continue;
//            }
//            overallMax *= array[i];
//        }
//
//        if (hashSet.size() >= 2) {
//            return  0;
//        }
//
//        int maxProductExcceptitSelf = array[0];
//
//        for (int i = 0 ; i < array.length ; i++ ) {
//            if (!hashSet.contains(i)) {
//                maxProductExcceptitSelf = Math.max(maxProductExcceptitSelf, overallMax / array[i]);
//            }
//        }
//
//        return maxProductExcceptitSelf;
//    }

    // On , if inplace, o1;
    public int MaxExceptItself(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        // DP, leftProduct num rightProduct

        // pre-possessing for each index product from left to right
        int[] products = new int[array.length];
        products[0] = array[0];
        for (int i = 1 ; i < array.length ; i++ ) {
            products[i] = products[i - 1] * array[i];
        }

        int overall = products[products.length - 1];

        int globalMax = array[0];
        // dp = max (left product * right product, dp)

        for (int i = 1 ; i < products.length ; i++ ) {
            int left = products[i - 1];
            int right = overall / products[i];

            globalMax = Math.max(globalMax, left * right);
        }

        return globalMax;
    }




}
