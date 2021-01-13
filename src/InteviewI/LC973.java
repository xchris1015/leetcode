package InteviewI;

import java.util.PriorityQueue;

public class LC973 {

    //1 define the cost
    //2 start status → state(复数）
    //3 expand/generate rule → convert, space complexity
    //4 termination
    //5 duplication, space complexity

    public int[][] kClosest(int[][] points, int K) {
        //cc

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((n1, n2) -> computeDistance(n2) - computeDistance(n1));

        for (int[] point : points) {
            maxHeap.offer(point);

            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[K][2];

        while (K > 0) {
            result[--K] = maxHeap.poll();
        }

        return result;
    }

    private int computeDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    // need quick selection

}
