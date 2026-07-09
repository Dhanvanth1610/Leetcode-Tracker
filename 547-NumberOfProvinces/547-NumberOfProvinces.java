// Last updated: 7/9/2026, 2:16:00 PM
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bfs(i, isConnected, vis);
                count++;
            }
        }

        return count;
    }
    public void bfs(int start, int[][] isConnected, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[curr][i] == 1 && !vis[i]) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
    }
}