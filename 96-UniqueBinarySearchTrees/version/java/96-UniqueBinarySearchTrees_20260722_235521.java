// Last updated: 7/22/2026, 11:55:21 PM
1class Solution {
2    public int numTrees(int n) {
3        int[] dp = new int[n + 1];
4
5        dp[0] = 1;
6        dp[1] = 1;
7
8        for (int nodes = 2; nodes <= n; nodes++) {
9            for (int root = 1; root <= nodes; root++) {
10                int left = root - 1;
11                int right = nodes - root;
12                dp[nodes] += dp[left] * dp[right];
13            }
14        }
15
16        return dp[n];
17    }
18}