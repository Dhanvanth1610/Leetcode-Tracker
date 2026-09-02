// Last updated: 9/2/2026, 9:13:20 AM
1class Solution {
2    private int preorderIndex;
3    private Map<Integer, Integer> mapping;
4
5    public TreeNode buildTree(int[] preorder, int[] inorder) {
6        mapping = new HashMap<>();
7        for (int i = 0; i < inorder.length; i++) {
8            mapping.put(inorder[i], i);
9        }
10
11        preorderIndex = 0;
12        return build(preorder, 0, inorder.length - 1);        
13    }
14
15    private TreeNode build(int[] preorder, int start, int end) {
16        if (start > end) return null;
17
18        int rootVal = preorder[preorderIndex++];
19        TreeNode root = new TreeNode(rootVal);
20        int mid = mapping.get(rootVal);
21
22        root.left = build(preorder, start, mid - 1);
23        root.right = build(preorder, mid + 1, end);
24
25        return root;
26    }
27}