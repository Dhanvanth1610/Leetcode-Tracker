// Last updated: 10/1/2026, 9:07:07 AM
1class Solution {
2    class SegTree {
3        int n;
4        int[] tree;
5        public SegTree(int size) {
6            n = 1;
7            while (n <= size) n *= 2;
8            tree = new int[2 * n];
9        }
10        
11        public void update(int i, int val) {
12            for (tree[i += n] = val; i > 1; i >>= 1) {
13                tree[i >> 1] = Math.max(tree[i], tree[i ^ 1]);
14            }
15        }
16        
17        public int query(int r) {
18            int res = 0;
19            for (int l = n, r_idx = r + n + 1; l < r_idx; l >>= 1, r_idx >>= 1) {
20                if ((l & 1) != 0) 
21                    res = Math.max(res, tree[l++]);
22                if ((r_idx & 1) != 0) 
23                    res = Math.max(res, tree[--r_idx]);
24            }
25            return res;
26        }
27    }
28
29    public List<Boolean> getResults(int[][] queries) {
30        int maxX = 0;
31        for (int[] q : queries) {
32            maxX = Math.max(maxX, q[1]);
33        }
34        
35        SegTree st = new SegTree(maxX + 1);
36        TreeSet<Integer> obstacles = new TreeSet<>();
37        obstacles.add(0);
38        List<Boolean> res = new ArrayList<>();
39        
40        for (int[] q : queries) {
41            int x = q[1];
42            if (q[0] == 1) {
43                Integer nxt = obstacles.ceiling(x);
44                Integer prev = obstacles.floor(x);
45                
46                st.update(x, x - prev);
47                if (nxt != null) {
48                    st.update(nxt, nxt - x);
49                }
50                obstacles.add(x);
51            } else {
52                int sz = q[2];
53                Integer prev = obstacles.floor(x);
54                int mx = Math.max(x - prev, st.query(prev));
55                res.add(sz <= mx);
56            }
57        }
58        return res;
59    }
60}