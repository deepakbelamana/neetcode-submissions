class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        String ns = new String();
        for (char c : s.toCharArray()) {
            int ascii = (int) c;
            if ((ascii >= 97 && ascii <= 127) || (ascii >= 48 && ascii <= 57)) {
                ns += c;
            }
        }
        int right = ns.length() - 1;
        while (left <= right) {
            if (ns.charAt(left) != ns.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
