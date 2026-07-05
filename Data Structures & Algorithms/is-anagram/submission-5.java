class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n != m) {
            return false;
        }
        for (int c = 0; c < s.length();) {
            char sc = s.charAt(c);
            if (t.indexOf(sc) == -1) {
                return false;
            } else {
                String s1 = s.substring(c + 1);
                int firstOccurence = t.indexOf(sc);
                String t1 = t.substring(0, firstOccurence) + t.substring(firstOccurence + 1);
                s = s1;
                t = t1;
            }
        }
        return true;
    }
}
