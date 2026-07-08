class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> bucket = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            bucket.add(new ArrayList<>());
        }
        HashMap<Integer, Integer> hm = new HashMap<>();

        int[] res = new int[k];

        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int count = entry.getValue();
            int element = entry.getKey();
            bucket.get(count - 1).add(element);
        }
        int r = 0;
        for (int n = bucket.size() - 1; n >= 0; n--) {
            List<Integer> freq = bucket.get(n);
            for (int ele : freq) {
                res[r] = ele;
                r++;
                if (r == res.length) {
                    return res;
                }
            }
        }

        return res;
    }
}
