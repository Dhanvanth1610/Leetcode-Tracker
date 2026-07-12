// Last updated: 7/12/2026, 6:34:11 PM
import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int closestSum = nums[0] + nums[1] + nums[2]; // initial
        
        for (int i = 0; i < n - 2; i++) {
            
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Update closest sum if better
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                if (currentSum < target) {
                    left++;   // increase sum
                } else if (currentSum > target) {
                    right--;  // decrease sum
                } else {
                    return currentSum; // exact match
                }
            }
        }
        
        return closestSum;
    }
}