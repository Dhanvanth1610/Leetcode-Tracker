// Last updated: 9/14/2026, 7:57:34 PM
1class Solution {
2    public int maxPathScore(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length;
4
5        int[] scoreAdd = {0, 1, 2};
6        int[] costAdd = {0, 1, 1};
7
8        // dp[i][j][c] = max score at (i, j) with cost c
9        int[][][] dp = new int[m][n][k + 1];
10        for (int i = 0; i < m; i++)
11            for (int j = 0; j < n; j++)
12                for (int c = 0; c <= k; c++)
13                    dp[i][j][c] = -1;
14
15        dp[0][0][0] = 0;
16
17        for (int i = 0; i < m; i++) {
18            for (int j = 0; j < n; j++) {
19                for (int costUsed = 0; costUsed <= k; costUsed++) {
20                    if (dp[i][j][costUsed] == -1) continue;
21                    int curScore = dp[i][j][costUsed];
22
23                    // Move DOWN
24                    if (i + 1 < m) {
25                        int nc = costUsed + costAdd[grid[i+1][j]];
26                        if (nc <= k) {
27                            int ns = curScore + scoreAdd[grid[i+1][j]];
28                            dp[i+1][j][nc] = Math.max(dp[i+1][j][nc], ns);
29                        }
30                    }
31
32                    // Move RIGHT
33                    if (j + 1 < n) {
34                        int nc = costUsed + costAdd[grid[i][j+1]];
35                        if (nc <= k) {
36                            int ns = curScore + scoreAdd[grid[i][j+1]];
37                            dp[i][j+1][nc] = Math.max(dp[i][j+1][nc], ns);
38                        }
39                    }
40                }
41            }
42        }
43
44        int best = -1;
45        for (int c = 0; c <= k; c++) {
46            best = Math.max(best, dp[m-1][n-1][c]);
47        }
48        return best;
49    }
50}