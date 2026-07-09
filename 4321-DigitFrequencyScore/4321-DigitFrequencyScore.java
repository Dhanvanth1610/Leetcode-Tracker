// Last updated: 7/9/2026, 2:13:41 PM
class Solution {
    public int digitFrequencyScore(int n) {
        int ans = 0;

        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }

        return ans;
    }
}