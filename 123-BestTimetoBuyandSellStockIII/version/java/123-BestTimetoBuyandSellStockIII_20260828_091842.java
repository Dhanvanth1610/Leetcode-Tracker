// Last updated: 8/28/2026, 9:18:42 AM
1class Solution {
2    public boolean isPalindrome(String s) {
3        if (s.isEmpty()) {
4        	return true;
5        }
6        int start = 0;
7        int last = s.length() - 1;
8        while(start <= last) {
9        	char currFirst = s.charAt(start);
10        	char currLast = s.charAt(last);
11        	if (!Character.isLetterOrDigit(currFirst )) {
12        		start++;
13        	} else if(!Character.isLetterOrDigit(currLast)) {
14        		last--;
15        	} else {
16        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
17        			return false;
18        		}
19        		start++;
20        		last--;
21        	}
22        }
23        return true;
24    }
25}