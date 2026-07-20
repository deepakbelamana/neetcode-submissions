class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            hashSet.add(i);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int hs : hashSet) {
            arrayList.add(hs);
        }
        for (int h = 0; h < hashSet.size(); h++) {
            hashMap.put(arrayList.get(h), h);
        }

        int longestConsecutiveSequence = 0;
        boolean[] mark = new boolean[hashSet.size()];
        for (int s : hashSet) {
            int temp = 0;
            if(mark[hashMap.get(s)]==true) {
                continue;
            }
            while (hashMap.containsKey(s + 1)) {
                temp += 1;
                s += 1;
                mark[hashMap.get(s)] = true;
            }
            longestConsecutiveSequence = Math.max(temp+1,longestConsecutiveSequence);
        }

        return longestConsecutiveSequence;
    }
}
