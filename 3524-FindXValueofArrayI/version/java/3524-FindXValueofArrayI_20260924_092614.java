// Last updated: 9/24/2026, 9:26:14 AM
1class Solution {
2    public boolean isGood(int[] nums) {
3        int mx = 0;
4
5        for (int x : nums) {
6            mx = Math.max(mx, x);
7        }
8
9        // size must be mx + 1
10        if (nums.length != mx + 1)
11            return false;
12
13        int[] freq = new int[mx + 1];
14
15        for (int x : nums) {
16            // invalid number
17            if (x < 1 || x > mx)
18                return false;
19
20            freq[x]++;
21        }
22
23        // 1 to mx-1 should appear once
24        for (int i = 1; i < mx; i++) {
25
26            if (freq[i] != 1)
27                return false;
28        }
29
30        // mx should appear twice
31        return freq[mx] == 2;
32    }
33}