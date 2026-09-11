// Last updated: 9/11/2026, 9:01:51 AM
1class Solution {
2    public int maxDistance(int[] A) {
3        int j = A.length;
4
5        for (int i = 0; i < j; i++)
6            if (A[i] != A[j - 1] || A[j - 1 - i] != A[0])
7                return j - 1 - i;
8
9        return 0;
10    }
11}