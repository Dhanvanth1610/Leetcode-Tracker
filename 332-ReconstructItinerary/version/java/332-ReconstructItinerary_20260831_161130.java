// Last updated: 8/31/2026, 4:11:30 PM
1import java.util.*;
2
3class Solution {
4    public int maxEnvelopes(int[][] envelopes) {
5
6        // Sort:
7        // Width ascending
8        // Height descending when widths are equal
9        Arrays.sort(envelopes, (a, b) -> {
10            if (a[0] == b[0]) {
11                return Integer.compare(b[1], a[1]);
12            }
13            return Integer.compare(a[0], b[0]);
14        });
15
16        // Find LIS on heights
17        int[] dp = new int[envelopes.length];
18        int size = 0;
19
20        for (int[] envelope : envelopes) {
21
22            int height = envelope[1];
23
24            int left = 0;
25            int right = size;
26
27            // Binary search
28            while (left < right) {
29
30                int mid = left + (right - left) / 2;
31
32                if (dp[mid] < height) {
33                    left = mid + 1;
34                } else {
35                    right = mid;
36                }
37            }
38
39            dp[left] = height;
40
41            if (left == size) {
42                size++;
43            }
44        }
45
46        return size;
47    }
48}