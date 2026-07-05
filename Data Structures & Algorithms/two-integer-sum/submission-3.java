class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sortArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortArray[i] = nums[i];
        }
        Arrays.sort(sortArray);
        int left = 0;
        int right = sortArray.length - 1;
        while (left < right) {
            int sum = sortArray[left] + sortArray[right];
            if (sum == target) {
                left = sortArray[left];
                right = sortArray[right];
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        int[] ref = new int[nums.length];
        int newLeft = 0;
        int newRight = 0;
        for (int j = 0; j < nums.length; j++) {
            if (left == nums[j] && ref[j] != 1 && left != Integer.MAX_VALUE) {
                newLeft = j;
                ref[j] = 1;
                left = Integer.MAX_VALUE;
            }
            if (right == nums[j] && ref[j] != 1 && right != Integer.MAX_VALUE) {
                newRight = j;
                ref[j] = 1;
                right = Integer.MAX_VALUE;
            }
        }
        int[] res = new int[] {newLeft, newRight};
        Arrays.sort(res);
        return res;
    }
}
