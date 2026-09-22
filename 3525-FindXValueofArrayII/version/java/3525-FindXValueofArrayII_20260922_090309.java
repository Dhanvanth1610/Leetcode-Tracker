// Last updated: 9/22/2026, 9:03:09 AM
1class Solution {
2    int[] tree_prod;
3    int[][] tree_cnt;
4    int K;
5
6    class Node {
7        int prod;
8        int[] cnt;
9        Node() {
10            cnt = new int[K];
11        }
12    }
13
14    public int[] resultArray(int[] nums, int k, int[][] queries) {
15        int n = nums.length;
16        this.K = k;
17        tree_prod = new int[4 * n];
18        tree_cnt = new int[4 * n][k];
19        build(1, 0, n - 1, nums);
20
21        int[] result = new int[queries.length];
22        for (int i = 0; i < queries.length; i++) {
23            int index = queries[i][0];
24            int value = queries[i][1];
25            int start = queries[i][2];
26            int x = queries[i][3];
27
28            
29            update(1, 0, n - 1, index, value);
30            
31    
32            Node resNode = query(1, 0, n - 1, start, n - 1);
33            result[i] = resNode.cnt[x];
34        }
35        
36        return result;
37    }
38
39    private void build(int node, int l, int r, int[] nums) {
40        if (l == r) {
41            tree_prod[node] = nums[l] % K;
42            tree_cnt[node][nums[l] % K] = 1;
43            return;
44        }
45        int mid = l + (r - l) / 2;
46        build(2 * node, l, mid, nums);
47        build(2 * node + 1, mid + 1, r, nums);
48        pushUp(node);
49    }
50
51    private void pushUp(int node) {
52        int left = 2 * node;
53        int right = 2 * node + 1;
54        
55       
56        tree_prod[node] = (tree_prod[left] * tree_prod[right]) % K;
57        
58 
59        for (int i = 0; i < K; i++) {
60            tree_cnt[node][i] = tree_cnt[left][i];
61        }
62        
63       
64        for (int i = 0; i < K; i++) {
65            if (tree_cnt[right][i] > 0) {
66                int new_val = (tree_prod[left] * i) % K;
67                tree_cnt[node][new_val] += tree_cnt[right][i];
68            }
69        }
70    }
71
72    private void update(int node, int l, int r, int idx, int val) {
73        if (l == r) {
74            tree_prod[node] = val % K;
75            for (int i = 0; i < K; i++) {
76                tree_cnt[node][i] = 0;
77            }
78            tree_cnt[node][val % K] = 1;
79            return;
80        }
81        
82        int mid = l + (r - l) / 2;
83        if (idx <= mid) {
84            update(2 * node, l, mid, idx, val);
85        } else {
86            update(2 * node + 1, mid + 1, r, idx, val);
87        }
88        pushUp(node);
89    }
90
91    private Node query(int node, int l, int r, int ql, int qr) {
92        if (ql <= l && r <= qr) {
93            Node res = new Node();
94            res.prod = tree_prod[node];
95            for (int i = 0; i < K; i++) {
96                res.cnt[i] = tree_cnt[node][i];
97            }
98            return res;
99        }
100        
101        int mid = l + (r - l) / 2;
102        if (qr <= mid) {
103            return query(2 * node, l, mid, ql, qr);
104        }
105        if (ql > mid) {
106            return query(2 * node + 1, mid + 1, r, ql, qr);
107        }
108
109        
110        Node leftNode = query(2 * node, l, mid, ql, qr);
111        Node rightNode = query(2 * node + 1, mid + 1, r, ql, qr);
112        
113        Node res = new Node();
114        res.prod = (leftNode.prod * rightNode.prod) % K;
115        for (int i = 0; i < K; i++) {
116            res.cnt[i] = leftNode.cnt[i];
117        }
118        for (int i = 0; i < K; i++) {
119            if (rightNode.cnt[i] > 0) {
120                int new_val = (leftNode.prod * i) % K;
121                res.cnt[new_val] += rightNode.cnt[i];
122            }
123        }
124        return res;
125    }
126}