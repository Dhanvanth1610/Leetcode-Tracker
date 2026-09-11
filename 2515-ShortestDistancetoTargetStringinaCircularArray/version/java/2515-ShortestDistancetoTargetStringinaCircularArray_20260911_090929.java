// Last updated: 9/11/2026, 9:09:29 AM
1class Solution {
2    public boolean hasValidPath(int[][] grid) {
3        int rows = grid.length, cols = grid[0].length;
4        Set<Integer>[] dirs = new HashSet[7];
5        dirs[1] = new HashSet<>(Arrays.asList(0, 1));
6        dirs[2] = new HashSet<>(Arrays.asList(2, 3));
7        dirs[3] = new HashSet<>(Arrays.asList(0, 3));
8        dirs[4] = new HashSet<>(Arrays.asList(1, 3));
9        dirs[5] = new HashSet<>(Arrays.asList(0, 2));
10        dirs[6] = new HashSet<>(Arrays.asList(1, 2));
11
12        int[][] moves = {{0, -1, 0, 1}, 
13                        {0, 1, 1, 0}, 
14                        {-1, 0, 2, 3}, 
15                        {1, 0, 3, 2}};
16        boolean[][] visited = new boolean[rows][cols];
17        Queue<int[]> q = new LinkedList<>();
18
19        q.offer(new int[]{0, 0});
20        visited[0][0] = true;
21
22        while (!q.isEmpty()) {
23            int[] curr = q.poll();
24            int r = curr[0], c = curr[1];
25            if (r == rows - 1 && c == cols - 1) 
26                return true;
27
28            for (int[] m : moves) {
29                int nr = r + m[0], nc = c + m[1];
30                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
31                    if (dirs[grid[r][c]].contains(m[2]) && dirs[grid[nr][nc]].contains(m[3])) {
32                        visited[nr][nc] = true;
33                        q.offer(new int[]{nr, nc});
34                    }
35                }
36            }
37        }
38        return false;
39    }
40}