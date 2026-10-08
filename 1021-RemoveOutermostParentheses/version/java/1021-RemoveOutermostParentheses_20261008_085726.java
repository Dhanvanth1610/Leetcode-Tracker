// Last updated: 10/8/2026, 8:57:26 AM
1class Solution {
2    public String removeOuterParentheses(String s) {
3        StringBuilder res = new StringBuilder();
4        int bal = 0;
5        for (char c : s.toCharArray()) {
6            if (c == '(') {
7                if (bal > 0) res.append(c);
8                bal++;
9            } else {
10                bal--;
11                if (bal > 0) res.append(c);
12            }
13        }
14        return res.toString();
15    }
16}