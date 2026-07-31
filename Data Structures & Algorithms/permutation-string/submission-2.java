class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = s1.length() - 1;
        HashMap<Character, Integer> originalMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            originalMap.put(c, originalMap.getOrDefault(c, 0) + 1);
        }
        while (right < s2.length()) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            int temp = left;
            while (temp <= right) {
                if (!originalMap.containsKey(s2.charAt(temp))) {
                    left++;
                    right++;
                    break;
                } else {
                    if (hashMap.containsKey(s2.charAt(temp))
                        && hashMap.get(s2.charAt(temp)) == originalMap.get(s2.charAt(temp))) {
                        left++;
                        right++;
                        break;
                    } else {
                        hashMap.put(s2.charAt(temp), 
                        hashMap.getOrDefault(s2.charAt(temp), 0) + 1);
                        temp++;
                    }
                }
            }
            if (hashMap.equals(originalMap))
                return true;
           
        }
        return false;
    }
    
}
