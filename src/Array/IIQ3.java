package Array;

import java.util.Stack;

public class IIQ3 {

    //Give a adjcent array, deduplicate with zero remaining

    //S1: hashmap, two pass, cannot use hashset(only good for duplicate time is two)

    //S2: stack, with one boolean, if true, pop when meet new single element and change back the boolean, postprocessing for last one

//    public int[] deduplicate(int[] array) {
//
//        if (array == null || array.length <= 1) {
//            return array;
//        }
//
//        Stack<Integer> stack = new Stack<>();
//        boolean currentDuplication = false;
//        // 2 2 2 4 4 4 5 6 6
//        // 2
//        for (int i = 0 ; i < array.length ; i++ ) {
//            if (stack.isEmpty() || (stack.peek() != array[i])) {
//                if (currentDuplication) {
//                    stack.pop();
//                } else {
//                    currentDuplication = false;
//                }
//                stack.push(array[i]);
//            } else {
//                currentDuplication = true;
//            }
//        }
//
//        if (currentDuplication) {
//            stack.pop();
//        }
//
//        int[] result = new int[stack.size()];
//
//        for (int j = result.length - 1 ; j >= 0 ; j-- ) {
//            result[j] = stack.pop();
//        }
//
//        return result;
//    }

    //S3: slow fast: S1: based on deduplicate with 1, with one boolean, if true, pop when meet new single
    // element and change back the boolean, postprocessing for last one.

//        public int[] deduplicate(int[] array) {
//
//            if (array == null || array.length <= 1) {
//                return array;
//            }
//
//            int slow = 0, fast = 1;
//            boolean currentDuplicate = false;
//
//            while (fast < array.length) {
//                if (array[fast] == array[slow]) {
//                    continue;
//                }
//
//                if (currentDuplicate) {
//                    continue;
//                }
//
//
//
//            }
//
//
//        }



}
