// Last updated: 8/30/2026, 8:49:24 PM
1class Solution {
2    public int minCut(String s) {
3        int n = s.length();
4
5        boolean[][] palindrome = new boolean[n][n];
6        int[] dp = new int[n];
7
8        for (int i = 0; i < n; i++) {
9            dp[i] = i;
10
11            for (int j = 0; j <= i; j++) {
12
13                if (s.charAt(j) == s.charAt(i) &&
14                    (i - j <= 1 || palindrome[j + 1][i - 1])) {
15
16                    palindrome[j][i] = true;
17
18                    if (j == 0) {
19                        dp[i] = 0;
20                    } else {
21                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
22                    }
23                }
24            }
25        }
26
27        return dp[n - 1];
28    }
29}