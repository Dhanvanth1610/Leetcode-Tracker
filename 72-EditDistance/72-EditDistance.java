// Last updated: 7/12/2026, 6:32:32 PM
import java.util.Arrays;

class Solution {

    int[][] dp;

    public int minDistance(String w1, String w2) {
        int n = w1.length();
        int m = w2.length();

        dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = helper(w1, w2, n, m);
        return ans;
    }

    public int helper(String ch1, String ch2, int n, int m) {

        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (ch1.charAt(n - 1) == ch2.charAt(m - 1)) {
            return dp[n][m] = helper(ch1, ch2, n - 1, m - 1);
        }

        int x = 1 + helper(ch1, ch2, n - 1, m);      // delete
        int y = 1 + helper(ch1, ch2, n - 1, m - 1);  // replace
        int z = 1 + helper(ch1, ch2, n, m - 1);      // insert

        return dp[n][m] = Math.min(x, Math.min(y, z));
    }
}