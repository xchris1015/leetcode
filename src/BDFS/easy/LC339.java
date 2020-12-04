package BDFS.easy;

public class LC339 {

//    public int depthSum(List<NestedInteger> nestedList) {
//
//        if (nestedList == null || nestedList.size() == 0) {
//            return 0;
//        }
//
//        Queue<NestedInteger> queue = new LinkedList<>();
//        for (NestedInteger nestedInteger : nestedList) {
//            queue.offer(nestedInteger);
//        }
//
//        int level = 1;
//        int sum = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//
//            while (size-- > 0) {
//                NestedInteger current = queue.poll();
//
//                if (current.isInteger()) {
//                    sum += current.getInteger() * level;
//                }
//
//                for (NestedInteger nested : current.getList()) {
//                    queue.offer(nested);
//                }
//            }
//
//            level++;
//        }
//
//        return sum;
//
//
//
//    }

    // follow up: reverse the level value
    //

//    public int depthSum(List<NestedInteger> nestedList) {
//
//        if (nestedList == null || nestedList.size() == 0) {
//            return 0;
//        }
//
//        Queue<NestedInteger> queue = new LinkedList<>();
//        for (NestedInteger nestedInteger : nestedList) {
//            queue.offer(nestedInteger);
//        }
//
//        int level = 1;
//        int sum = 0;
//        int singleItems = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//
//            while (size-- > 0) {
//                NestedInteger current = queue.poll();
//
//                if (current.isInteger()) {
//                    singleItems += current.getInteger();
//                    continue;
//                }
//
//                for (NestedInteger nested : current.getList()) {
//                    queue.offer(nested);
//                }
//            }
//            sum += singleItems;
//
//        }
//
//        return sum;
//
//
//
//    }

}
