// Last updated: 10/10/2026, 4:05:20 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<String> summaryRanges(int[] nums) {
6        List<String> result = new ArrayList<>();
7        if (nums.length == 0) {
8            return result;
9        }
10        
11        int i = 0;
12        while (i < nums.length) {
13            int start = nums[i];
14            int j = i;
15            // Expand the range as long as elements are consecutive
16            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
17                j++;
18            }
19            
20            // Format the range string
21            if (nums[j] == start) {
22                result.add(String.valueOf(start));
23            } else {
24                result.add(start + "->" + nums[j]);
25            }
26            
27            // Move to the next potential start of a range
28            i = j + 1;
29        }
30        return result;
31    }
32}