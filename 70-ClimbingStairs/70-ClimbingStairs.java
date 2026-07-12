// Last updated: 7/12/2026, 6:32:35 PM
class Solution {
    public int climbStairs(int n) {
        int dp[] =new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    } 
    public int helper(int n,int dp[]){
    
            if(n<=2){
                dp[n]=n;
                return n;
            }
            if(dp[n]!=-1){
                return dp[n];
            }
            dp[n]=helper(n-1,dp) + helper(n-2 ,dp);
            return dp[n];
     }
   
       
}      
    
        // if (n <= 2) {
        //     return n;
        // }

        // int ele1 = 1;
        // int ele2 = 2;

        // for (int i = 3; i <= n; i++) {
        //     int curr = ele1 + ele2;
        //     ele1 = ele2;
        //     ele2 = curr;
        // }

        // return ele2;
    
        
        
    
