class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int length = 0;
        for(int right = 0; right<s.length();right++) {
            freq[s.charAt(right)-'A']+=1;
            maxFreq = Math.max(maxFreq,freq[s.charAt(right)-'A']);
            int window = right-left+1;
            if(window-maxFreq<=k){
                length=Math.max(length,window);
            } else {
                freq[s.charAt(left)-'A']-=1;
                left++;
            }
        }
        return length;
    }
}
