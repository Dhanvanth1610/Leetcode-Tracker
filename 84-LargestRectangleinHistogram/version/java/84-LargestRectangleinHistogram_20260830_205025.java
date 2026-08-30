// Last updated: 8/30/2026, 8:50:25 PM
1import java.util.*;
2
3class Solution {
4
5    public List<String> wordBreak(String s, List<String> wordDict) {
6        Set<String> dict = new HashSet<>(wordDict);
7
8        Map<Integer, List<String>> memo = new HashMap<>();
9
10        return solve(s, 0, dict, memo);
11    }
12
13    private List<String> solve(
14            String s,
15            int start,
16            Set<String> dict,
17            Map<Integer, List<String>> memo) {
18
19        if (memo.containsKey(start)) {
20            return memo.get(start);
21        }
22
23        List<String> result = new ArrayList<>();
24
25        // Reached the end
26        if (start == s.length()) {
27            result.add("");
28            return result;
29        }
30
31        for (int end = start + 1; end <= s.length(); end++) {
32
33            String word = s.substring(start, end);
34
35            if (dict.contains(word)) {
36
37                List<String> remaining =
38                    solve(s, end, dict, memo);
39
40                for (String sentence : remaining) {
41
42                    if (sentence.isEmpty()) {
43                        result.add(word);
44                    } else {
45                        result.add(word + " " + sentence);
46                    }
47                }
48            }
49        }
50
51        memo.put(start, result);
52
53        return result;
54    }
55}