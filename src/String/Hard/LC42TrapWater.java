package String.Hard;

public class LC42TrapWater {

    public int trap(int[] height) {

        if (height == null || height.length <= 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];
        int result = 0;

        // the leftMax and rightMax is increasing, so if current leftMax < rightMax, means all of the time the current leftMax < rightMax;

        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                result += (leftMax - height[left]);
                left++;
            } else {
                result += (rightMax - height[right]);
                right--;
            }
        }

        return result;
    }
}
