// Last updated: 8/28/2026, 9:27:20 AM
1class Solution {
2    public int longestConsecutive(int[] nums) {
3        Set<Integer> numSet = new HashSet<>();
4
5        for (int num : nums) {
6            numSet.add(num);
7        }
8
9        int longest = 0;
10
11        for (int n : numSet) {
12            if (!numSet.contains(n - 1)) {
13                int length = 1;
14
15                while (numSet.contains(n + length)) {
16                    length++;
17                }
18
19                longest = Math.max(longest, length);
20            }
21        }
22
23        return longest;
24    }
25}