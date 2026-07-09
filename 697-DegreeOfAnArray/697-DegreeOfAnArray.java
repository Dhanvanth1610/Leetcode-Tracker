// Last updated: 7/9/2026, 2:15:28 PM
import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            first.putIfAbsent(nums[i], i);
            last.put(nums[i], i);
        }

        int degree = 0;
        for (int c : count.values()) {
            degree = Math.max(degree, c);
        }

        int ans = nums.length;
        for (int key : count.keySet()) {
            if (count.get(key) == degree) {
                ans = Math.min(ans, last.get(key) - first.get(key) + 1);
            }
        }

        return ans;
    }
}