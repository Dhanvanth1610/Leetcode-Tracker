// Last updated: 9/11/2026, 9:03:48 AM
1class Solution {
2    boolean hasMatch(String query, String[] dictionary) {
3        boolean found = false;
4        for (String dict : dictionary) {
5            int diffMax = 2;
6            for (int i=0;i<dict.length();i++) {
7                if (dict.charAt(i) != query.charAt(i)) {
8                    diffMax--;
9                }
10                if (diffMax < 0) {
11                    break;
12                }
13            }
14            if (diffMax >= 0) {
15                return true;
16            }
17        }
18
19        return found;
20    }
21
22    public List<String> twoEditWords(String[] queries, String[] dictionary) {
23
24        List<String> result = new ArrayList<>();
25        for (String query : queries) {
26            if (hasMatch(query, dictionary)) {
27                result.add(query);
28            }
29        }
30
31        return result;
32    }
33}