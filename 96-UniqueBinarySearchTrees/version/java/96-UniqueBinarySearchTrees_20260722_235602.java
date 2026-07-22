// Last updated: 7/22/2026, 11:56:02 PM
1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    private Map<String, Boolean> memo = new HashMap<>();
6
7    public boolean isScramble(String s1, String s2) {
8        if (s1.equals(s2)) {
9            return true;
10        }
11
12        String key = s1 + "#" + s2;
13        if (memo.containsKey(key)) {
14            return memo.get(key);
15        }
16
17        // Check if both strings have the same characters
18        int[] count = new int[26];
19        for (int i = 0; i < s1.length(); i++) {
20            count[s1.charAt(i) - 'a']++;
21            count[s2.charAt(i) - 'a']--;
22        }
23
24        for (int c : count) {
25            if (c != 0) {
26                memo.put(key, false);
27                return false;
28            }
29        }
30
31        int n = s1.length();
32
33        for (int i = 1; i < n; i++) {
34
35            // Case 1: No swap
36            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
37                isScramble(s1.substring(i), s2.substring(i))) {
38                memo.put(key, true);
39                return true;
40            }
41
42            // Case 2: Swap
43            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
44                isScramble(s1.substring(i), s2.substring(0, n - i))) {
45                memo.put(key, true);
46                return true;
47            }
48        }
49
50        memo.put(key, false);
51        return false;
52    }
53}