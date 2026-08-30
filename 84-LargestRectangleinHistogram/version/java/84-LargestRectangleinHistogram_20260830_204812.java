// Last updated: 8/30/2026, 8:48:12 PM
1import java.util.*;
2
3class Solution {
4    public int largestRectangleArea(int[] heights) {
5        Stack<Integer> stack = new Stack<>();
6        int maxArea = 0;
7
8        for (int i = 0; i <= heights.length; i++) {
9
10            int currentHeight = (i == heights.length) ? 0 : heights[i];
11
12            while (!stack.isEmpty() && 
13                   currentHeight < heights[stack.peek()]) {
14
15                int height = heights[stack.pop()];
16
17                int width;
18
19                if (stack.isEmpty()) {
20                    width = i;
21                } else {
22                    width = i - stack.peek() - 1;
23                }
24
25                maxArea = Math.max(maxArea, height * width);
26            }
27
28            stack.push(i);
29        }
30
31        return maxArea;
32    }
33}