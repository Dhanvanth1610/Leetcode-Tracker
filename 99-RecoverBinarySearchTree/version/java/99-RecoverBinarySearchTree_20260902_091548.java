// Last updated: 9/2/2026, 9:15:48 AM
1class Solution {
2    private Map<Integer, Integer> inorderIndexes = new HashMap<>();
3    private int i_post;
4
5    private TreeNode solve(int[] postorder, int[] inorder, int start, int end) {
6        if (start > end || i_post < 0)
7            return null;
8
9        TreeNode node = new TreeNode(postorder[i_post]);
10
11        int i_in = inorderIndexes.get(postorder[i_post]);
12
13        i_post--;
14
15        node.right = solve(postorder, inorder, i_in + 1, end);
16        node.left = solve(postorder, inorder, start, i_in - 1);
17
18        return node;
19    }
20
21    public TreeNode buildTree(int[] inorder, int[] postorder) {
22        for (int i = 0; i < inorder.length; i++)
23            inorderIndexes.put(inorder[i], i);
24
25        i_post = postorder.length - 1;
26
27        return solve(postorder, inorder, 0, inorder.length - 1);
28    }
29}