// Last updated: 9/8/2026, 9:11:17 PM
1class Solution {
2    public int countCommas(int n) {
3        int count = 0;
4
5        for (int i = 1; i <= n; i++) {
6            if (i >= 1000) {
7                count++;
8            }
9        }
10
11        return count;
12    }
13}