// Last updated: 7/9/2026, 2:15:07 PM
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(s1, s2, n1, n2, dp);
    }

    int helper(String ch1, String ch2, int n1, int n2, int[][] dp) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        }

        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }

        if (ch1.charAt(n1 - 1) == ch2.charAt(n2 - 1)) {
            return dp[n1][n2] =
                1 + helper(ch1, ch2, n1 - 1, n2 - 1, dp);
        }

        int ans1 = helper(ch1, ch2, n1 - 1, n2, dp);
        int ans2 = helper(ch1, ch2, n1, n2 - 1, dp);

        return dp[n1][n2] = Math.max(ans1, ans2);
    }
}