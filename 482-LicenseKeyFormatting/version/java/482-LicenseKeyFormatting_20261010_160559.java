// Last updated: 10/10/2026, 4:05:59 PM
1class Solution {
2    public String licenseKeyFormatting(String s, int k) {
3        int count = 0;
4        s = s.toUpperCase();
5        StringBuilder sb = new StringBuilder();
6        for(int i = s.length() - 1; i >= 0; i--){
7            char ch = s.charAt(i);
8            if(ch == '-'){
9                continue;
10            }
11            if(count == k){
12                sb.append('-');
13                count = 0;
14            }
15            sb.append(ch);
16            count++; 
17        }
18        return sb.reverse().toString();
19    }
20}