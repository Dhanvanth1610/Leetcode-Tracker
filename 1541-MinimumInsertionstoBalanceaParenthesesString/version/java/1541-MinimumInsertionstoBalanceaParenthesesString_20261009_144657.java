// Last updated: 10/9/2026, 2:46:57 PM
1class Solution {
2    public int minInsertions(String s) {
3        Stack<Character> stack = new Stack<>();
4        int ans = 0;
5
6        for (int i = 0; i < s.length(); i++) {
7            char ch = s.charAt(i);
8
9            if (ch == '(') {
10                stack.push(ch);
11            } else {
12                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
13                    i++;
14                } else {
15                    ans++;
16                }
17
18                if (!stack.isEmpty()) {
19                    stack.pop();
20                } else {
21                    ans++;
22                }
23            }
24        }
25
26        return ans + stack.size() * 2;
27    }
28}