// Last updated: 9/2/2026, 9:12:26 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public List<List<Integer>> levelOrder(TreeNode root) {
18
19        List<List<Integer>> result = new ArrayList<>();
20
21        helper(result, root, 0);
22        return result;
23
24    }
25
26    public void helper(List<List<Integer>> result, TreeNode root, int level){
27
28        if(root == null) return;
29
30        if(level == result.size()){
31            List<Integer> ls = new ArrayList<>();
32            ls.add(root.val);
33            result.add(ls);
34        }else{
35            result.get(level).add(root.val);
36        }
37
38        helper(result, root.left, level+1);
39        helper(result, root.right, level+1);
40    }
41}