class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int area = 0;
        while(left<right) {
            int width = right-left;
            int height = Math.min(heights[right],heights[left]);
            area = Math.max(area,width*height);
            if(heights[left]<heights[right]){
                left++;
            } else {
                right--;
            }

        }
        return area;
    }
}
