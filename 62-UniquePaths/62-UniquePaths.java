// Last updated: 7/12/2026, 6:32:51 PM
import java.util.Arrays;

class Solution {

    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = helper(0, 0, m, n);
        return ans;
    }

    public int helper(int i, int j, int m, int n) {
        if (i >= m || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int x = helper(i + 1, j, m, n);
        int y = helper(i, j + 1, m, n);

        return dp[i][j] = x + y;
    }
}