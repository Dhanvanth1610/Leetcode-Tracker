// Last updated: 10/22/2026, 8:58:16 AM
1class Solution {
2    public int minOperations(int[] nums) {
3        int n = nums.length;
4        List<int[]> starts = new ArrayList<>();
5        boolean inc = true, dec = true;
6        for (int i = 0; i < n; i++) {
7            if (nums[(i + 1) % n] != (nums[i] + 1) % n) inc = false;
8            if (nums[(i + 1) % n] != (nums[i] - 1 + n) % n) dec = false;
9        }
10        if (inc) starts.add(new int[]{0, nums[0]});
11        if (dec) starts.add(new int[]{1, (n - 1 - nums[0] + n) % n});
12        if (starts.isEmpty()) return -1;
13
14        int[][] dist = new int[2][n];
15        for (int[] row : dist) Arrays.fill(row, -1);
16        Queue<int[]> q = new ArrayDeque<>();
17        for (int[] p : starts) {
18            dist[p[0]][p[1]] = 0;
19            q.offer(p);
20        }
21        while (!q.isEmpty()) {
22            int[] cur = q.poll();
23            int t = cur[0], s = cur[1];
24            if (t == 0 && s == 0) return dist[t][s];
25            int d = dist[t][s];
26            int nt = t, ns = (s + 1) % n;
27            if (dist[nt][ns] == -1) {
28                dist[nt][ns] = d + 1;
29                q.offer(new int[]{nt, ns});
30            }
31            nt = 1 - t;
32            ns = (n - s) % n;
33            if (dist[nt][ns] == -1) {
34                dist[nt][ns] = d + 1;
35                q.offer(new int[]{nt, ns});
36            }
37        }
38        return -1;
39    }
40}