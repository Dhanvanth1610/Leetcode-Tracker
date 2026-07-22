// Last updated: 7/22/2026, 11:56:39 PM
1class Solution {
2    public int numDecodings(String s) {
3        int n = s.length();
4
5        if (n == 0 || s.charAt(0) == '0') {
6            return 0;
7        }
8
9        int[] dp = new int[n + 1];
10        dp[0] = 1;
11        dp[1] = 1;
12
13        for (int i = 2; i <= n; i++) {
14            // Single digit decode
15            if (s.charAt(i - 1) != '0') {
16                dp[i] += dp[i - 1];
17            }
18
19            // Two digit decode
20            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
21            if (twoDigit >= 10 && twoDigit <= 26) {
22                dp[i] += dp[i - 2];
23            }
24        }
25
26        return dp[n];
27    }
28}