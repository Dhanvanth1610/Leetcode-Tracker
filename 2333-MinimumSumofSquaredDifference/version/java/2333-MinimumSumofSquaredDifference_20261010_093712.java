// Last updated: 10/10/2026, 9:37:12 AM
1class Solution {
2    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
3        int n = nums1.length;
4        int[] d = new int[n];
5        long total = 0;
6        int mx = 0;
7        for (int i = 0; i < n; ++i) {
8            d[i] = Math.abs(nums1[i] - nums2[i]);
9            total += d[i];
10            mx = Math.max(mx, d[i]);
11        }
12        long k = (long)k1 + k2;
13        if (total <= k) return 0;
14        int left = 0, right = mx;
15        while (left < right) {
16            int mid = left + (right - left) / 2;
17            long need = 0;
18            for (int v : d) need += Math.max(0, v - mid);
19            if (need <= k) right = mid;
20            else left = mid + 1;
21        }
22        for (int i = 0; i < n; ++i) {
23            k -= Math.max(0, d[i] - left);
24            d[i] = Math.min(d[i], left);
25        }
26        for (int i = 0; i < n && k > 0; ++i) {
27            if (d[i] == left) {
28                --d[i];
29                --k;
30            }
31        }
32        long ans = 0;
33        for (int v : d) ans += (long)v * v;
34        return ans;
35    }
36}