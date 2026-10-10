// Last updated: 10/10/2026, 4:03:53 PM
1class Solution {
2    TreeNode prev=null,first=null,second=null;
3    void inorder(TreeNode root){
4        if(root==null)
5            return ;
6        inorder(root.left);
7        if(prev!=null&&root.val<prev.val){
8            if(first==null)
9                first=prev;
10            second=root;
11        }
12        prev=root;
13        inorder(root.right);
14    }
15    public void recoverTree(TreeNode root) {
16        if(root==null)
17            return ; 
18        inorder(root);
19        int temp=first.val;
20        first.val=second.val;
21        second.val=temp;
22    }
23}