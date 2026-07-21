class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder ns = new StringBuilder();
        for (char c : s.toCharArray()) {
            int ascii = (int) c;
            if ((ascii >= 97 && ascii <= 122) || (ascii >= 48 && ascii <= 57)) {
                ns.append(c);
            }
        }
        int left = 0, right = ns.length() - 1;
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
