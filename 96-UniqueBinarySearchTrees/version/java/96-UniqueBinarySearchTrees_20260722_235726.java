// Last updated: 7/22/2026, 11:57:26 PM
1class Solution {
2    public int numDistinct(String s, String t) {
3        int m = s.length();
4        int n = t.length();
5
6        long[][] dp = new long[m + 1][n + 1];
7
8        for (int i = 0; i <= m; i++) {
9            dp[i][0] = 1;
10        }
11
12        for (int i = 1; i <= m; i++) {
13            for (int j = 1; j <= n; j++) {
14                if (s.charAt(i - 1) == t.charAt(j - 1)) {
15                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
16                } else {
17                    dp[i][j] = dp[i - 1][j];
18                }
19            }
20        }
21
22        return (int) dp[m][n];
23    }
24}