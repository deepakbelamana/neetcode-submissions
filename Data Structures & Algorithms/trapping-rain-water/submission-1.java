class Solution {
    public int trap(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        while (left < right) {
            if (height[left] < height[right]) {
                int leftArea = maxLeft - height[left];   // only maxLeft, not min(maxLeft, maxRight)
                if (leftArea > 0) {
                    area += leftArea;
                }
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                }
                left++;
            } else {
                int rightArea = maxRight - height[right]; // only maxRight
                if (rightArea > 0) {
                    area += rightArea;
                }
                if (height[right] > maxRight) {
                    maxRight = height[right];
                }
                right--;
            }
        }
        return area;
    }
}