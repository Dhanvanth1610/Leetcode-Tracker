# Last updated: 8/1/2026, 8:34:23 PM
1class Solution(object):
2    def countValidPrefixes(self, s):
3        zero= one=ans=0
4        for ch in s:
5            if ch == '0':
6                zero +=1
7            else:
8                one +=1
9            if abs(zero - one) <=1:
10                ans+=1
11        return ans
12        