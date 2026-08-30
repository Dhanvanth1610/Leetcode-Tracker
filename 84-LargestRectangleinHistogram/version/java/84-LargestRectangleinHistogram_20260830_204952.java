// Last updated: 8/30/2026, 8:49:52 PM
1class Solution {
2    public int candy(int[] ratings) {
3        int n = ratings.length;
4
5        int[] candies = new int[n];
6
7        // Give every child 1 candy
8        for (int i = 0; i < n; i++) {
9            candies[i] = 1;
10        }
11
12        // Left to right
13        for (int i = 1; i < n; i++) {
14            if (ratings[i] > ratings[i - 1]) {
15                candies[i] = candies[i - 1] + 1;
16            }
17        }
18
19        // Right to left
20        for (int i = n - 2; i >= 0; i--) {
21            if (ratings[i] > ratings[i + 1]) {
22                candies[i] = Math.max(
23                    candies[i],
24                    candies[i + 1] + 1
25                );
26            }
27        }
28
29        // Calculate total
30        int total = 0;
31
32        for (int candy : candies) {
33            total += candy;
34        }
35
36        return total;
37    }
38}