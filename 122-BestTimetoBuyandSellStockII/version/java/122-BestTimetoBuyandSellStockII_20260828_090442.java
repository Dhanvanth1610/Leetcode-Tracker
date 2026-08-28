// Last updated: 8/28/2026, 9:04:42 AM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int max = 0;
4        int start = prices[0];
5
6        for(int i=0;i<prices.length;i++)
7        {
8            if(prices[i]>start)
9            {
10                max = max+ prices[i]-start;
11            }
12            start = prices[i];
13        }
14        return max;
15    }
16}