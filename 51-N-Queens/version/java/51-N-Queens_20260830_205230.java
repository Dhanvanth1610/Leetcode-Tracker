// Last updated: 8/30/2026, 8:52:30 PM
1class Solution {
2    public int calculateMinimumHP(int[][] dungeon) {
3
4        int m = dungeon.length;
5        int n = dungeon[0].length;
6
7        int[][] dp = new int[m + 1][n + 1];
8
9        // Initialize with a very large value
10        for (int i = 0; i <= m; i++) {
11            for (int j = 0; j <= n; j++) {
12                dp[i][j] = Integer.MAX_VALUE;
13            }
14        }
15
16        // Boundary conditions
17        dp[m][n - 1] = 1;
18        dp[m - 1][n] = 1;
19
20        // Fill from bottom-right to top-left
21        for (int i = m - 1; i >= 0; i--) {
22
23            for (int j = n - 1; j >= 0; j--) {
24
25                int nextHealth = Math.min(
26                    dp[i + 1][j],
27                    dp[i][j + 1]
28                );
29
30                dp[i][j] = Math.max(
31                    1,
32                    nextHealth - dungeon[i][j]
33                );
34            }
35        }
36
37        return dp[0][0];
38    }
39}