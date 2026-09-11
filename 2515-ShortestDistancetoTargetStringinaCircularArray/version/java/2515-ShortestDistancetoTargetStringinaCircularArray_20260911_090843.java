// Last updated: 9/11/2026, 9:08:43 AM
1class Solution {
2    int[] parent;
3    int[] rank;
4
5    public int find(int x){
6        if(parent[x] == x){
7            return x;
8        }
9
10        return parent[x] = find(parent[x]);
11
12    }
13
14    public void union(int x, int y){
15        int px = find(x);
16        int py = find(y);
17
18        if(px == py){
19            return;
20        }
21
22        if(rank[px] < rank[py]){
23            parent[px] = py;
24
25        }
26        else if(rank[py] < rank[px]){
27            parent[py] = px;
28        }
29        else{
30            parent[px] = py;
31            rank[py]++;
32        }
33    }
34
35
36    public boolean containsCycle(char[][] grid) {
37        int n = grid.length;
38        int m = grid[0].length;
39
40        parent = new int[n * m];
41        rank = new int[n * m];
42
43        for(int i=0; i<n*m; i++){
44            parent[i] = i;
45            rank[i] = 0;
46        }
47
48        for(int i=0; i<n; i++){
49            for(int j=0; j<m; j++){
50
51                int curr = i * m + j;
52
53                // right
54                if(j + 1 < m && grid[i][j] == grid[i][j + 1]){
55                    int next = i * m + (j + 1);
56
57                    if(find(curr) == find(next)){
58                        return true;
59                    }
60
61                    union(curr, next);
62
63
64                }
65                
66                if(i + 1 < n && grid[i][j] == grid[i + 1][j]){
67                    int next = (i + 1) * m + j;
68
69                    if(find(curr) == find(next)){
70                        return true;
71                    }
72
73                    union(curr, next);
74
75
76                }
77
78            }
79        }
80
81        return false;
82
83
84        
85    }
86}