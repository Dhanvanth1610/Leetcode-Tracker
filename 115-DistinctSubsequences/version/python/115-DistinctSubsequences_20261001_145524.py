# Last updated: 10/1/2026, 2:55:24 PM
1class Solution:
2    def numDistinct(self, s, t):
3        n, m = len(s), len(t)
4
5        dp = [[0] * (m + 1) for _ in range(n + 1)]
6
7        for i in range(n + 1):
8            dp[i][m] = 1
9
10        for i in range(n - 1, -1, -1):
11            for j in range(m - 1, -1, -1):
12                dp[i][j] = dp[i + 1][j]
13
14                if s[i] == t[j]:
15                    dp[i][j] += dp[i + 1][j + 1]
16
17        return dp[0][0]