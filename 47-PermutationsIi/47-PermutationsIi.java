// Last updated: 7/12/2026, 6:33:10 PM
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutations(0, nums, ans);
        return ans;
    }

    public void permutations(int i, int[] nums, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }

            ans.add(temp);
            return;
        }
        HashSet<Integer> mb = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (mb.contains(nums[j])) {
                continue;
            }
            mb.add(nums[j]);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            permutations(i + 1, nums, ans);
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}