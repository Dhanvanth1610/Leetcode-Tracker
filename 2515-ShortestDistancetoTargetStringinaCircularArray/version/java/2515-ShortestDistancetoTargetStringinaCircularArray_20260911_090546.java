// Last updated: 9/11/2026, 9:05:46 AM
1class Solution {
2    private static final char LETTER_L = 'L';
3    private static final char LETTER_R = 'R';
4    private static final char CHARACTER_ = '_';
5
6    public int furthestDistanceFromOrigin(String moves) {
7        int n = moves.length();
8
9        int countL = 0;
10        int countR = 0;
11        int countUnderscore = 0;
12        
13        for (int i = 0; i < n; i++) {
14            char c = moves.charAt(i);
15            if (c == LETTER_L) {
16                countL++;
17            } else if (c == LETTER_R) {
18                countR++;
19            } else if (c == CHARACTER_) {
20                countUnderscore++;
21            }
22        }
23
24        int positionAllL = (countL + countUnderscore) - countR;
25        int positionAllR = countL - (countR + countUnderscore);
26        
27        return Math.max(Math.abs(positionAllL), Math.abs(positionAllR));
28    }
29}