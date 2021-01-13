package InteviewI;

public class LC42 {

    public int trap(int[] height) {
        //cc

        int left = 0;
        int right = height.length - 1;

        int leftMaxSoFar = height[left];
        int rightMaxSoFar = height[right];
        int water = 0;
        while (left <= right) {
            leftMaxSoFar = Math.max(leftMaxSoFar, height[left]);
            rightMaxSoFar = Math.max(rightMaxSoFar, height[right]);

            if (leftMaxSoFar < rightMaxSoFar) {
                water += (leftMaxSoFar - height[left]);
                left++;
            } else {
                water += (rightMaxSoFar - height[right]);
                right--;
            }
        }

        return water;

    }
}
