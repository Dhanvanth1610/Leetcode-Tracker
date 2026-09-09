// Last updated: 9/9/2026, 9:02:59 AM
1class Solution {
2    public int closestTarget(String[] words, String target, int start) {
3        int n = words.length;
4        for (int i = 0; i <= n >> 1; i++)
5            if (words[(start + i) % n].equals(target) |
6                words[(start - i + n) % n].equals(target))
7                return i;
8
9        return -1;
10    }
11}