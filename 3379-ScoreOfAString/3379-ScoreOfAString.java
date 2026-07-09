// Last updated: 7/9/2026, 2:14:09 PM
class Solution {
    public int scoreOfString(String s) {
        int score = 0;

        for (int i = 1; i < s.length(); i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }

        return score;
    }
}