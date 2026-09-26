// Last updated: 9/26/2026, 4:53:15 PM
1class Solution {
2    public String evaluate(String s, List<List<String>> knowledge) {
3        Map<String, String> d = new HashMap<>();
4
5        for (List<String> item : knowledge) {
6            d.put(item.get(0), item.get(1));
7        }
8
9        StringBuilder ans = new StringBuilder();
10        int start = -1;
11
12        for (int i = 0; i < s.length(); i++) {
13            char c = s.charAt(i);
14
15            if (c == '(') {
16                start = i;
17            }
18            else if (c == ')') {
19                String key = s.substring(start + 1, i);
20
21                ans.append(d.getOrDefault(key, "?"));
22                start = -1;
23            }
24            else if (start < 0) {
25                ans.append(c);
26            }
27        }
28
29        return ans.toString();
30    }
31}