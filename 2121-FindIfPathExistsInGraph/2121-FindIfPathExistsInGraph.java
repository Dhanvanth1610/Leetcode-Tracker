// Last updated: 7/9/2026, 2:14:42 PM
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
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

        return dfs(source, destination, adj, vis);
    }

    public boolean dfs(int node, int destination,
                       ArrayList<ArrayList<Integer>> adj,
                       boolean[] vis) {

        if (node == destination) {
            return true;
        }

        vis[node] = true;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int neighbor = adj.get(node).get(i);

            if (!vis[neighbor]) {
                if (dfs(neighbor, destination, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
}