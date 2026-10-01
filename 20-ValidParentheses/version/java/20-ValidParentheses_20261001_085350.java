// Last updated: 10/1/2026, 8:53:50 AM
1class Solution {
2    public boolean isValid(String str) {
3        if (str.length() % 2 == 1)
4            return false;
5
6        char[] S = str.toCharArray();
7        int j = 0;
8
9        for (char c : S)
10            if ((c & 3) != 1)
11                S[j++] = c;
12            else if (j == 0 || ((c - S[--j] + 1) >> 1) != 1)
13                return false;        
14
15        return j == 0;
16    }
17}