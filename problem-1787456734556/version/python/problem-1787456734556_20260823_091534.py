# Last updated: 8/23/2026, 9:15:34 AM
1class Solution(object):
2    def isPalindromic(self, s):
3        binary = ""
4        for ch in s:
5            binary +=format(ord(ch),'08b')
6        return binary == binary[::-1]