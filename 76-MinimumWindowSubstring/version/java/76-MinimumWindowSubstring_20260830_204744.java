// Last updated: 8/30/2026, 8:47:44 PM
1import java.util.*;
2
3class Solution {
4    public String minWindow(String s, String t) {
5        if (s.length() < t.length()) {
6            return "";
7        }
8
9        Map<Character, Integer> need = new HashMap<>();
10        Map<Character, Integer> window = new HashMap<>();
11
12        for (char c : t.toCharArray()) {
13            need.put(c, need.getOrDefault(c, 0) + 1);
14        }
15
16        int left = 0;
17        int right = 0;
18        int have = 0;
19        int required = need.size();
20
21        int minLength = Integer.MAX_VALUE;
22        int start = 0;
23
24        while (right < s.length()) {
25            char c = s.charAt(right);
26            window.put(c, window.getOrDefault(c, 0) + 1);
27
28            if (need.containsKey(c) &&
29                window.get(c).intValue() == need.get(c).intValue()) {
30                have++;
31            }
32
33            while (have == required) {
34
35                if (right - left + 1 < minLength) {
36                    minLength = right - left + 1;
37                    start = left;
38                }
39
40                char leftChar = s.charAt(left);
41                window.put(leftChar, window.get(leftChar) - 1);
42
43                if (need.containsKey(leftChar) &&
44                    window.get(leftChar) < need.get(leftChar)) {
45                    have--;
46                }
47
48                left++;
49            }
50
51            right++;
52        }
53
54        if (minLength == Integer.MAX_VALUE) {
55            return "";
56        }
57
58        return s.substring(start, start + minLength);
59    }
60}