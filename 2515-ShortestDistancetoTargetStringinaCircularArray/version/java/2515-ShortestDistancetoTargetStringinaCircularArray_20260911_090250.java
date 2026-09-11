// Last updated: 9/11/2026, 9:02:50 AM
1class Solution {
2    private int[] parent;
3
4    private int find(int x) {
5        if (parent[x] != x)
6            parent[x] = find(parent[x]);
7        return parent[x];
8    }
9
10    private void unite(int a, int b) {
11        parent[find(a)] = find(b);
12    }
13
14    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
15        int n = source.length;
16        parent = new int[n];
17        for (int i = 0; i < n; i++) parent[i] = i;
18
19        for (int[] swap : allowedSwaps)
20            unite(swap[0], swap[1]);
21
22        // Group source values by their root
23        Map<Integer, Map<Integer, Integer>> groupFreq = new HashMap<>();
24        for (int i = 0; i < n; i++) {
25            int root = find(i);
26            groupFreq.computeIfAbsent(root, k -> new HashMap<>())
27                     .merge(source[i], 1, Integer::sum);
28        }
29
30        int hammingDistance = 0;
31        for (int i = 0; i < n; i++) {
32            int root = find(i);
33            Map<Integer, Integer> freq = groupFreq.get(root);
34            if (freq.getOrDefault(target[i], 0) > 0)
35                freq.merge(target[i], -1, Integer::sum);
36            else
37                hammingDistance++;
38        }
39
40        return hammingDistance;
41    }
42}