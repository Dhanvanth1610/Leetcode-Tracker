// Last updated: 8/31/2026, 4:09:01 PM
1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> palindromePairs(String[] words) {
5
6        List<List<Integer>> result = new ArrayList<>();
7
8        Map<String, Integer> map = new HashMap<>();
9
10        // Store reversed words
11        for (int i = 0; i < words.length; i++) {
12            map.put(new StringBuilder(words[i]).reverse().toString(), i);
13        }
14
15        for (int i = 0; i < words.length; i++) {
16
17            String word = words[i];
18
19            for (int j = 0; j <= word.length(); j++) {
20
21                String left = word.substring(0, j);
22                String right = word.substring(j);
23
24                // Case 1: Left part is palindrome
25                if (isPalindrome(left)) {
26                    Integer index = map.get(right);
27
28                    if (index != null && index != i) {
29                        result.add(Arrays.asList(index, i));
30                    }
31                }
32
33                // Case 2: Right part is palindrome
34                if (j != word.length() && isPalindrome(right)) {
35                    Integer index = map.get(left);
36
37                    if (index != null && index != i) {
38                        result.add(Arrays.asList(i, index));
39                    }
40                }
41            }
42        }
43
44        return result;
45    }
46
47    private boolean isPalindrome(String s) {
48
49        int left = 0;
50        int right = s.length() - 1;
51
52        while (left < right) {
53            if (s.charAt(left) != s.charAt(right)) {
54                return false;
55            }
56
57            left++;
58            right--;
59        }
60
61        return true;
62    }
63}