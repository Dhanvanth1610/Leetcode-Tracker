// Last updated: 7/9/2026, 2:17:24 PM
class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    ans++;
                    bfs(i, j, vis, grid, m, n);
                }
            }
        }

        return ans;
    }

    static void bfs(int i, int j, boolean[][] vis,
                    char[][] grid, int m, int n) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});
        vis[i][j] = true;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for (int k = 0; k < 4; k++) {
                int nextRow = row + dir[k][0];
                int nextCol = col + dir[k][1];

                if (nextRow >= 0 &&
                    nextRow < m &&
                    nextCol >= 0 &&
                    nextCol < n &&
                    grid[nextRow][nextCol] == '1' &&
                    !vis[nextRow][nextCol]) {

                    vis[nextRow][nextCol] = true;
                    q.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}