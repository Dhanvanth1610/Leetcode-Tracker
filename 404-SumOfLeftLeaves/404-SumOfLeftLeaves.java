// Last updated: 7/9/2026, 2:16:32 PM
class Solution {

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null &&
                root.left.left == null &&
                root.left.right == null) {
            return root.left.val;
        }

        return 0;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root)
                + sumOfLeftLeaves(root.left)
                + sumOfLeftLeaves(root.right);
    }
}