// Last updated: 9/30/2026, 12:47:46 PM
1class Solution {
2    public int[] maxDepthAfterSplit(String seq) {
3        int n = seq.length();
4        int[] res = new int[n];
5        
6        for (int i = 0; i < n; i++)
7            res[i] = (i ^ seq.charAt(i)) & 1;
8            
9        return res;
10    }
11}