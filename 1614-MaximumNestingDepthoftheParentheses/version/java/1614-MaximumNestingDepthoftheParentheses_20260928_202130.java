// Last updated: 9/28/2026, 8:21:30 PM
1class Solution {
2    public int maxDepth(String s) {
3        int ans = 0, depth = 0;
4        for (char ch : s.toCharArray()) {
5            depth += ch == '(' ? 1 : ch == ')' ? -1 : 0;
6            ans = Math.max(ans, depth);
7        }
8        return ans;
9    }
10}