// Last updated: 8/31/2026, 4:09:59 PM
1import java.util.*;
2
3class SummaryRanges {
4
5    TreeSet<Integer> set;
6
7    public SummaryRanges() {
8        set = new TreeSet<>();
9    }
10
11    public void addNum(int value) {
12        set.add(value);
13    }
14
15    public int[][] getIntervals() {
16
17        List<int[]> result = new ArrayList<>();
18
19        if (set.isEmpty()) {
20            return new int[0][0];
21        }
22
23        int start = -1;
24        int prev = -1;
25
26        for (int num : set) {
27
28            if (start == -1) {
29                start = num;
30                prev = num;
31            }
32            else if (num == prev + 1) {
33                // Continue the current interval
34                prev = num;
35            }
36            else {
37                // Close previous interval
38                result.add(new int[]{start, prev});
39
40                start = num;
41                prev = num;
42            }
43        }
44
45        // Add last interval
46        result.add(new int[]{start, prev});
47
48        return result.toArray(new int[result.size()][]);
49    }
50}