// Last updated: 9/5/2026, 11:50:22 PM
1class Solution {
2    public int stoneGameVIII(int[] stones) {
3        int n = stones.length;
4
5        int[] prefix = stones.clone();
6
7        // Build prefix sums
8        for (int i = 1; i < n; i++) {
9            prefix[i] += prefix[i - 1];
10        }
11
12        // If Alice takes all stones,
13        // the game ends immediately.
14        int best = prefix[n - 1];
15
16        // Try every earlier valid prefix
17        for (int i = n - 2; i >= 1; i--) {
18            best = Math.max(best, prefix[i] - best);
19        }
20
21        return best;
22    }
23}