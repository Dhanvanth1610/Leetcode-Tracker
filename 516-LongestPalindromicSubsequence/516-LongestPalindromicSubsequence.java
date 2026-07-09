// Last updated: 7/9/2026, 2:16:04 PM
class Solution {

    int[][] dp;

    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int n = s.length();
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(s, r, n, n);
    }
    int helper(String ch1, String ch2, int n1, int n2) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        }
        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }
        if (ch1.charAt(n1 - 1) == ch2.charAt(n2 - 1)) {
            return dp[n1][n2] =
                1 + helper(ch1, ch2, n1 - 1, n2 - 1);
        }
        int ans1 = helper(ch1, ch2, n1 - 1, n2);
        int ans2 = helper(ch1, ch2, n1, n2 - 1);
        return dp[n1][n2] = Math.max(ans1, ans2);
    }
}