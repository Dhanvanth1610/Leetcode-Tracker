// Last updated: 9/28/2026, 8:23:13 PM
1import java.util.Arrays;
2import java.util.HashSet;
3import java.util.Set;
4
5class Solution {
6    public int numberOfSpecialChars(String word) {
7        int[] lastLower = new int[26];
8        int[] firstUpper = new int[26];
9
10        Arrays.fill(lastLower, -1);
11        Arrays.fill(firstUpper, -1);
12
13        Set<Integer> invalid = new HashSet<>();
14
15        for (int i = 0; i < word.length(); i++) {
16            char ch = word.charAt(i);
17
18            if (ch >= 'a' && ch <= 'z') {
19                int idx = ch - 'a';
20
21                lastLower[idx] = i;
22
23                if (firstUpper[idx] != -1) {
24                    invalid.add(idx);
25                }
26
27            } else {
28                int idx = ch - 'A';
29
30                if (firstUpper[idx] == -1) {
31                    firstUpper[idx] = i;
32                }
33            }
34        }
35
36        int specialCount = 0;
37
38        for (int i = 0; i < 26; i++) {
39            if (lastLower[i] != -1 &&
40                firstUpper[i] != -1 &&
41                !invalid.contains(i)) {
42
43                specialCount++;
44            }
45        }
46
47        return specialCount;
48    }
49}