// Last updated: 9/14/2026, 7:55:49 PM
1class Solution {
2    public int minOperations(int[][] grid, int x) {
3        int n = grid.length, m = grid[0].length;
4        int[] freq = new int[10001];
5        //check -1 cases
6        boolean foundFalse = false;
7        int currChoice = grid[0][0];
8        for (int[] row : grid) {
9            for (int y : row) {
10                freq[y]++;
11                if (Math.abs(currChoice - y) % x != 0)
12                    foundFalse = true;
13            }
14        }
15        if (foundFalse) return -1;
16        //sorting
17        int[] arr = new int[n * m];
18        int k = 0;
19        for (int i = 0; i < 10001; i++) {
20            for (int j = 0; j < freq[i]; j++) {
21                arr[k++] = i;
22            }
23        }
24        int count = 0;
25        //pick best middle element
26        int median = arr[arr.length / 2];
27        for (int num : arr) {
28            count += Math.abs(num - median) / x;
29        }
30        return count;
31    }
32}