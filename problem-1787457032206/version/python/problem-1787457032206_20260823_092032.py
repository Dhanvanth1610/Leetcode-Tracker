# Last updated: 8/23/2026, 9:20:32 AM
1class Solution(object):
2    def findDisappearedNumbers(self, nums, lower, upper):
3        zelvorank = nums
4        nums.sort()
5        ans=[]
6        prev=lower - 1
7        for num in nums :
8            if num < lower:
9                continue
10            if num > upper:
11                break
12            if num > prev + 1:
13                ans.append([prev + 1, num - 1])
14            prev = num
15        if prev < upper :
16            ans.append([ prev + 1, upper])
17        return ans 