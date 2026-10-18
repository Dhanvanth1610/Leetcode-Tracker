// Last updated: 10/18/2026, 12:47:11 PM
1class Solution {
2    private static final int MOD = 1_000_000_007;
3    private long[][] comb;
4
5    public int numOfWays(int[] nums) {
6        int n = nums.length;
7
8        comb = new long[n + 1][n + 1];
9
10        for (int i = 0; i <= n; i++) {
11            comb[i][0] = comb[i][i] = 1;
12
13            for (int j = 1; j < i; j++) {
14                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
15            }
16        }
17
18        long ans = solve(nums);
19        return (int) ((ans - 1 + MOD) % MOD);
20    }
21
22    private long solve(java.util.List<Integer> nums) {
23        int n = nums.size();
24
25        if (n <= 2) {
26            return 1;
27        }
28
29        int root = nums.get(0);
30
31        java.util.List<Integer> left = new java.util.ArrayList<>();
32        java.util.List<Integer> right = new java.util.ArrayList<>();
33
34        for (int i = 1; i < n; i++) {
35            if (nums.get(i) < root) {
36                left.add(nums.get(i));
37            } else {
38                right.add(nums.get(i));
39            }
40        }
41
42        long leftWays = solve(left);
43        long rightWays = solve(right);
44
45        long ways = comb[n - 1][left.size()];
46        ways = ways * leftWays % MOD;
47        ways = ways * rightWays % MOD;
48
49        return ways;
50    }
51
52    private long solve(int[] nums) {
53        java.util.List<Integer> list = new java.util.ArrayList<>();
54
55        for (int num : nums) {
56            list.add(num);
57        }
58
59        return solve(list);
60    }
61}