// Last updated: 9/28/2026, 8:22:39 PM
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        
4        HashSet<Character> set = new HashSet<>();
5
6        for(char ch : word.toCharArray()) {
7            set.add(ch);
8        }
9
10        int count = 0;
11
12        for(char ch = 'a'; ch <= 'z'; ch++) {
13
14            if(set.contains(ch) && set.contains((char)(ch - 'a' + 'A'))) {
15                count++;
16            }
17        }
18
19        return count;
20    }
21}