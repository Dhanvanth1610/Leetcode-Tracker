// Last updated: 7/12/2026, 6:33:18 PM
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        
        int leftMax = 0;
        int rightMax = 0;
        
        while (left < right) {
            // Decide whether to process from the left or right side
            if (height[left] < height[right]) {
                // If current left height is greater than leftMax, update it
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Otherwise, we can definitely trap water here
                    ans += (leftMax - height[left]);
                }
                left++;
            } else {
                // If current right height is greater than rightMax, update it
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Otherwise, we can definitely trap water here
                    ans += (rightMax - height[right]);
                }
                right--;
            }
        }
        
        return ans;
    }
}


