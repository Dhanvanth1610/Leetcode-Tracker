// Last updated: 9/14/2026, 7:59:58 PM
1class Solution {
2    public int rotatedDigits(int n) {
3        int count = 0;
4        
5        for (int i = 1; i <= n; i++) {
6            int num = i;
7            boolean isValid = true;
8            boolean hasChange = false;
9            
10            while (num > 0) {
11                int digit = num % 10;
12                
13                if (digit == 3 || digit == 4 || digit == 7) {
14                    isValid = false;
15                    break;
16                }
17                
18                if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
19                    hasChange = true;
20                }
21                
22                num /= 10;
23            }
24            
25            if (isValid && hasChange) {
26                count++;
27            }
28        }
29        
30        return count;
31    }
32}