// Last updated: 8/28/2026, 9:10:11 AM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4        int[][] next = new int[2][3];
5
6        for(int idx=n-1;idx>=0;idx--){
7            int[][] curr = new int[2][3];
8            for(int canBuy=0;canBuy<=1;canBuy++){
9                for(int transactionsLeft=1;transactionsLeft<=2;transactionsLeft++){
10                    int profit = 0;
11
12                    if(canBuy == 1){
13                        profit = Math.max(-prices[idx] + next[0][transactionsLeft], 0 + next[1][transactionsLeft]);
14                    }
15                    else{
16                        profit = Math.max(prices[idx] + next[1][transactionsLeft-1], 0 + next[0][transactionsLeft]);
17                    }
18
19                    curr[canBuy][transactionsLeft] = profit;
20                }
21            }
22            next = curr;
23        }
24
25        return next[1][2];
26    }
27}