// Last updated: 9/24/2026, 9:29:10 AM
1class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3
4        int p1 = 0, p2 = 0;
5
6        while (p1 < nums1.length && p2 < nums2.length) {
7
8            if (nums1[p1] == nums2[p2]) {
9                return nums1[p1];
10            }
11
12            else if (nums1[p1] < nums2[p2]) {
13                p1++;
14            }
15
16            else {
17                p2++;
18            }
19        }
20
21        return -1;
22    }
23}