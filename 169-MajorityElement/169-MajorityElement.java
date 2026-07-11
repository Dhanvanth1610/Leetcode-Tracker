// Last updated: 7/11/2026, 1:34:37 PM
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> mb = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            mb.put(nums[i], mb.getOrDefault(nums[i], 0) + 1);
        }

        int m = n / 2;

        for (Map.Entry<Integer, Integer> en : mb.entrySet()) {
            if (en.getValue() > m) {
                return en.getKey();
            }
        }

        return 0;
    }
}