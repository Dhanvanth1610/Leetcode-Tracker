// Last updated: 7/9/2026, 2:17:14 PM
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] a1 = new int[n - 1]; 
        int[] a2 = new int[n - 1]; 

        for (int i = 0; i < n - 1; i++) {
            a1[i] = nums[i];
        }

        for (int i = 1; i < n; i++) {
            a2[i - 1] = nums[i];
        }

        int[] dp1 = new int[n - 1];
        Arrays.fill(dp1, -1);

        int[] dp2 = new int[n - 1];
        Arrays.fill(dp2, -1);

        int ans1 = helper(a1.length - 1, a1, dp1);
        int ans2 = helper(a2.length - 1, a2, dp2);

        return Math.max(ans1, ans2);
    }

    public int helper(int i, int[] nums, int[] dp) {
        if (i < 0) {
            return 0;
        }

        if (i == 0) {
            return nums[0];
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take = nums[i] + helper(i - 2, nums, dp);
        int nottake = helper(i - 1, nums, dp);

        return dp[i] = Math.max(take, nottake);
    }
}