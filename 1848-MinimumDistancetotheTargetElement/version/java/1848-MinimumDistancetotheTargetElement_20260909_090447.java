// Last updated: 9/9/2026, 9:04:47 AM
1class Solution {
2    public int minMirrorPairDistance(int[] nums) {
3        int res = 100000, i = 0;
4        HashMap<Integer, Integer> seen = new HashMap<>();
5
6        for (int n : nums) {
7            int r;
8            if (seen.containsKey(n))
9                res = Math.min(res, i - seen.get(n));
10
11            for (r = 0; n > 0; n /= 10)
12                r = r * 10 + (n % 10);
13
14            seen.put(r, i++);
15        }
16
17        return res == 100000 ? -1 : res;
18    }
19}