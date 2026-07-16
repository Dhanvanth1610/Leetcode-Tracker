// Last updated: 7/16/2026, 2:36:20 PM
1import java.util.*;
2
3class Solution {
4    public List<Integer> findSubstring(String s, String[] words) {
5        List<Integer> result = new ArrayList<>();
6
7        if (s == null || s.length() == 0 || words == null || words.length == 0)
8            return result;
9
10        int wordLen = words[0].length();
11        int wordCount = words.length;
12        int totalLen = wordLen * wordCount;
13
14        if (s.length() < totalLen)
15            return result;
16
17        Map<String, Integer> wordMap = new HashMap<>();
18
19        for (String word : words) {
20            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
21        }
22
23        for (int i = 0; i < wordLen; i++) {
24            int left = i;
25            int count = 0;
26            Map<String, Integer> window = new HashMap<>();
27
28            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
29
30                String word = s.substring(right, right + wordLen);
31
32                if (wordMap.containsKey(word)) {
33                    window.put(word, window.getOrDefault(word, 0) + 1);
34                    count++;
35
36                    while (window.get(word) > wordMap.get(word)) {
37                        String leftWord = s.substring(left, left + wordLen);
38                        window.put(leftWord, window.get(leftWord) - 1);
39                        left += wordLen;
40                        count--;
41                    }
42
43                    if (count == wordCount) {
44                        result.add(left);
45
46                        String leftWord = s.substring(left, left + wordLen);
47                        window.put(leftWord, window.get(leftWord) - 1);
48                        left += wordLen;
49                        count--;
50                    }
51                } else {
52                    window.clear();
53                    count = 0;
54                    left = right + wordLen;
55                }
56            }
57        }
58
59        return result;
60    }
61}