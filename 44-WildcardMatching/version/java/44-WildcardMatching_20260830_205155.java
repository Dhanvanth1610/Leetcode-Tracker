// Last updated: 8/30/2026, 8:51:55 PM
1class Solution {
2    public boolean isMatch(String s, String p) {
3
4        int i = 0;  // pointer for s
5        int j = 0;  // pointer for p
6
7        int star = -1;
8        int match = 0;
9
10        while (i < s.length()) {
11
12            // Normal character or ?
13            if (j < p.length() &&
14                (p.charAt(j) == '?' ||
15                 p.charAt(j) == s.charAt(i))) {
16
17                i++;
18                j++;
19            }
20
21            // Found *
22            else if (j < p.length() && p.charAt(j) == '*') {
23
24                star = j;
25                match = i;
26                j++;
27            }
28
29            // Previous * can match current character
30            else if (star != -1) {
31
32                j = star + 1;
33                match++;
34                i = match;
35            }
36
37            // No match
38            else {
39                return false;
40            }
41        }
42
43        // Remaining characters in pattern must be *
44        while (j < p.length() && p.charAt(j) == '*') {
45            j++;
46        }
47
48        return j == p.length();
49    }
50}