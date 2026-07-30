class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = left;
        int length = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!hashMap.containsKey(c) || hashMap.get(s.charAt(right)) == null) {
                hashMap.put(s.charAt(right), right);
            } else if (hashMap.get(s.charAt(right)) != null) {
                int dupValue = hashMap.get(s.charAt(right));
                length = Math.max(length, right - left);
                left = dupValue + 1;
                for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
                    Integer indexValue = entry.getValue();
                    if (indexValue != null && indexValue <= dupValue) {
                        entry.setValue(null);
                    }
                }
                hashMap.put(s.charAt(right), right);
            }
            right++;
        }

        length = Math.max(length, right - left);
        return length;
    }
}
