// Last updated: 7/9/2026, 2:17:25 PM
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {
            int m = q.size();

            for (int i = 0; i < m; i++) {
                TreeNode curr = q.poll();

                if (i == m - 1) {
                    ans.add(curr.val);
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return ans;
    }
}