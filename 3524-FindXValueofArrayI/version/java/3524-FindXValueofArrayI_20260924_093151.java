// Last updated: 9/24/2026, 9:31:51 AM
1class Solution {
2    public boolean check(int[] nums) {
3        int breaks = 0;
4        int n = nums.length;
5
6        for (int i = 0; i < n; i++) {
7            if (nums[i] > nums[(i + 1) % n]) {
8                breaks++;
9            }
10        }
11
12        return breaks <= 1;
13    }
14}