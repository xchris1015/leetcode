package String.medium;

import java.util.ArrayList;
import java.util.List;

public class LC11ContainerOfWater {

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int left = 0, right = height.length - 1, area = 0;

        while (left <= right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return area;
    }

}
