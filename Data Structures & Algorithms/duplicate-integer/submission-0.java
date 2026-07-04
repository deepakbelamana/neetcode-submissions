class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums) {
            if(!hashSet.add(i)){
                return true;
            }
        }
        return false;
    }
}