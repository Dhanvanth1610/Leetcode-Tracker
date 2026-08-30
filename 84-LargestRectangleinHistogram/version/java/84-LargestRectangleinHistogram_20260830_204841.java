// Last updated: 8/30/2026, 8:48:41 PM
1import java.util.*;
2
3class Solution {
4
5    public int maximalRectangle(char[][] matrix) {
6        if (matrix.length == 0) {
7            return 0;
8        }
9
10        int columns = matrix[0].length;
11        int[] heights = new int[columns];
12
13        int maxArea = 0;
14
15        for (int i = 0; i < matrix.length; i++) {
16
17            // Build histogram
18            for (int j = 0; j < columns; j++) {
19                if (matrix[i][j] == '1') {
20                    heights[j]++;
21                } else {
22                    heights[j] = 0;
23                }
24            }
25
26            // Find largest rectangle in histogram
27            maxArea = Math.max(maxArea, largestRectangleArea(heights));
28        }
29
30        return maxArea;
31    }
32
33    private int largestRectangleArea(int[] heights) {
34
35        Stack<Integer> stack = new Stack<>();
36        int maxArea = 0;
37
38        for (int i = 0; i <= heights.length; i++) {
39
40            int currentHeight =
41                (i == heights.length) ? 0 : heights[i];
42
43            while (!stack.isEmpty() &&
44                   currentHeight < heights[stack.peek()]) {
45
46                int height = heights[stack.pop()];
47
48                int width;
49
50                if (stack.isEmpty()) {
51                    width = i;
52                } else {
53                    width = i - stack.peek() - 1;
54                }
55
56                maxArea = Math.max(maxArea, height * width);
57            }
58
59            stack.push(i);
60        }
61
62        return maxArea;
63    }
64}