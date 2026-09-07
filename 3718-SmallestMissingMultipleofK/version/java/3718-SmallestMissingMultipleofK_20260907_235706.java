// Last updated: 9/7/2026, 11:57:06 PM
1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        long[] x = {0L, 0L};
4        for (int n : nums)
5            if (n % k == 0) {
6                int i = n / k - 1;
7                x[i >> 6] |= 1L << (i & 63);
8            }
9            
10        int z = x[0] == -1L ? 1 : 0;
11        return (z * 64 + Long.numberOfTrailingZeros(++x[z] & -x[z]) + 1) * k;
12    }
13}