// Last updated: 7/11/2026, 1:34:16 PM
class Solution {
    public int rob(int[] nums) {
    //     int n=nums.length;
    //     int ans=helper(n-1, nums);
    //     return ans;
    // }
    // public int helper(int i,int nums[]){
    //     if(i<0){
    //         return 0;
    //     }
    //     int take=nums[i] + helper(i-2, nums);
    //     int out =0+helper(i-1, nums);
    //     int ams=Math.max(take,out);
    //     return ams;
    // }
        int n= nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n-1,nums,dp);
        
    }
    public int helper(int i,int nums[],int dp[]){
        if(i<0){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take=nums[i] + helper(i-2, nums,dp);
        int out =0+helper(i-1, nums,dp);
        int ams=Math.max(take,out);
        dp[i]=ams;
        return dp[i];
    }


    
}