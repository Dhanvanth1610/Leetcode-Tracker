// Last updated: 9/10/2026, 10:22:16 AM
1class Solution {
2    int ans = 0;
3    public int averageOfSubtree(TreeNode root) {
4        dfs(root);
5        return ans;
6    }
7    private int[] dfs(TreeNode node) {
8        if (node == null) return new int[]{0, 0};
9        int[] left = dfs(node.left);
10        int[] right = dfs(node.right);
11        int sum = left[0] + right[0] + node.val;
12        int cnt = left[1] + right[1] + 1;
13        if (sum / cnt == node.val) ans++;
14        return new int[]{sum, cnt};
15    }
16}