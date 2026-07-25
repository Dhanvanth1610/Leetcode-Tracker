// Last updated: 7/25/2026, 4:12:05 PM
1class Solution {
2    public List<String> fullJustify(String[] words, int maxWidth) {
3        List<String> result = new ArrayList<>();
4        int i = 0;
5
6        while (i < words.length) {
7            int j = i;
8            int lineLength = 0;
9
10            // Find how many words fit in one line
11            while (j < words.length &&
12                    lineLength + words[j].length() + (j - i) <= maxWidth) {
13                lineLength += words[j].length();
14                j++;
15            }
16
17            int gaps = j - i - 1;
18            StringBuilder line = new StringBuilder();
19
20            // Last line or only one word
21            if (j == words.length || gaps == 0) {
22                for (int k = i; k < j; k++) {
23                    line.append(words[k]);
24                    if (k != j - 1) {
25                        line.append(" ");
26                    }
27                }
28
29                while (line.length() < maxWidth) {
30                    line.append(" ");
31                }
32            } else {
33                int totalSpaces = maxWidth - lineLength;
34                int spaceEach = totalSpaces / gaps;
35                int extra = totalSpaces % gaps;
36
37                for (int k = i; k < j; k++) {
38                    line.append(words[k]);
39
40                    if (k != j - 1) {
41                        for (int s = 0; s < spaceEach; s++) {
42                            line.append(" ");
43                        }
44                        if (extra > 0) {
45                            line.append(" ");
46                            extra--;
47                        }
48                    }
49                }
50            }
51
52            result.add(line.toString());
53            i = j;
54        }
55
56        return result;
57    }
58}