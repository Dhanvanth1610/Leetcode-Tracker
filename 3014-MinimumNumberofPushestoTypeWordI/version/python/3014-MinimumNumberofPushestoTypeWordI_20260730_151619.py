# Last updated: 7/30/2026, 3:16:19 PM
1class Solution(object):
2    def minimumPushes(self, word):
3        a=len(word)
4        c=0
5        while(a!=0):
6            if(a>24):
7                a-=1
8                c+=4
9            elif(a>16):
10                a-=1
11                c+=3
12            elif(a>8):
13                a-=1
14                c+=2
15            else:
16                a-=1
17                c+=1
18        return c