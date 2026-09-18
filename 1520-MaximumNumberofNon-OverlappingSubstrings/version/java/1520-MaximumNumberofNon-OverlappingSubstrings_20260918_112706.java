// Last updated: 9/18/2026, 11:27:06 AM
1class Solution {
2    public List<String> maxNumOfSubstrings(String s) {
3        int n = s.length();
4
5        int[] first = new int[26];
6        int[] last = new int[26];
7        Arrays.fill(first, n);
8        Arrays.fill(last, -1);
9
10        // Find first and last occurrence
11        for (int i = 0; i < n; i++) {
12            int c = s.charAt(i) - 'a';
13            first[c] = Math.min(first[c], i);
14            last[c] = i;
15        }
16
17        List<int[]> intervals = new ArrayList<>();
18
19        // Build valid intervals
20        for (int c = 0; c < 26; c++) {
21            if (last[c] == -1) continue;
22
23            int l = first[c];
24            int r = last[c];
25            boolean valid = true;
26
27            for (int i = l; i <= r; i++) {
28                int x = s.charAt(i) - 'a';
29
30                // x has an occurrence before l
31                if (first[x] < l) {
32                    valid = false;
33                    break;
34                }
35
36                // Must include all occurrences of x
37                r = Math.max(r, last[x]);
38            }
39
40            if (valid)
41                intervals.add(new int[]{r, l});
42        }
43
44        // Earliest ending interval first
45        intervals.sort((a, b) -> {
46            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
47            return Integer.compare(a[1], b[1]);
48        });
49
50        List<String> ans = new ArrayList<>();
51        int prevEnd = -1;
52
53        for (int[] iv : intervals) {
54            int r = iv[0], l = iv[1];
55            if (l > prevEnd) {
56                ans.add(s.substring(l, r + 1));
57                prevEnd = r;
58            }
59        }
60
61        return ans;
62    }
63}