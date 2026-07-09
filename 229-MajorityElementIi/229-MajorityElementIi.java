// Last updated: 7/9/2026, 2:17:03 PM
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> mb = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            mb.put(nums[i], mb.getOrDefault(nums[i], 0) + 1);
        }

        int m = n / 3;

        for (Map.Entry<Integer, Integer> en : mb.entrySet()) {
            if (en.getValue() > m) {
                ans.add(en.getKey());
            }
        }

        return ans;
    }
}