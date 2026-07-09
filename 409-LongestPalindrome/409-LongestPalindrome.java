// Last updated: 7/9/2026, 2:16:29 PM
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        boolean odd = false;

        for (int freq : count) {
            length += (freq / 2) * 2;
            if (freq % 2 == 1) {
                odd = true;
            }
        }

        return odd ? length + 1 : length;
    }
}