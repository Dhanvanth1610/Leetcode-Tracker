// Last updated: 7/9/2026, 2:14:21 PM
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int[] res = bfs(i, adj, vis);

                int nodes = res[0];
                int edgeCount = res[1] / 2;

                if (edgeCount == nodes * (nodes - 1) / 2) {
                    count++;
                }
            }
        }

        return count;
    }

    public int[] bfs(int start,
                     ArrayList<ArrayList<Integer>> adj,
                     boolean[] vis) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        vis[start] = true;

        int nodes = 0;
        int degreeSum = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            nodes++;
            degreeSum += adj.get(curr).size();

            for (int i = 0; i < adj.get(curr).size(); i++) {
                int neighbor = adj.get(curr).get(i);

                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }

        return new int[]{nodes, degreeSum};
    }
}