// Last updated: 9/25/2026, 8:56:19 AM
1import java.util.*;
2
3class Solution {
4
5    public List<String> braceExpansionII(String expression) {
6        Set<String> result = dfs(expression, 0, expression.length() - 1);
7        return new ArrayList<>(result);
8    }
9
10    private Set<String> dfs(String s, int l, int r) {
11
12        Set<String> result = new TreeSet<>();
13        int balance = 0;
14
15        // Check for top-level comma
16        for (int i = l; i <= r; i++) {
17
18            if (s.charAt(i) == '{') {
19                balance++;
20            } 
21            else if (s.charAt(i) == '}') {
22                balance--;
23            } 
24            else if (s.charAt(i) == ',' && balance == 0) {
25
26                result.addAll(dfs(s, l, i - 1));
27                result.addAll(dfs(s, i + 1, r));
28
29                return result;
30            }
31        }
32
33        // If entire expression is inside braces
34        if (s.charAt(l) == '{' && matchingBrace(s, l) == r) {
35            return dfs(s, l + 1, r - 1);
36        }
37
38        // Concatenation
39        result.add("");
40
41        int i = l;
42
43        while (i <= r) {
44
45            Set<String> part;
46
47            if (s.charAt(i) == '{') {
48
49                int j = matchingBrace(s, i);
50
51                part = dfs(s, i + 1, j - 1);
52
53                i = j + 1;
54
55            } else {
56
57                part = new TreeSet<>();
58                part.add(String.valueOf(s.charAt(i)));
59
60                i++;
61            }
62
63            // Combine current results with this part
64            Set<String> newResult = new TreeSet<>();
65
66            for (String a : result) {
67                for (String b : part) {
68                    newResult.add(a + b);
69                }
70            }
71
72            result = newResult;
73        }
74
75        return result;
76    }
77
78    private int matchingBrace(String s, int start) {
79
80        int balance = 0;
81
82        for (int i = start; i < s.length(); i++) {
83
84            if (s.charAt(i) == '{') {
85                balance++;
86            } 
87            else if (s.charAt(i) == '}') {
88                balance--;
89
90                if (balance == 0) {
91                    return i;
92                }
93            }
94        }
95
96        return -1;
97    }
98}