// Last updated: 7/12/2026, 6:33:14 PM
class Solution {
    public List<List<Integer>> permute(int[] nums) {
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
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            permutations(i + 1, nums, ans);
            swap(nums, i, j); 
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}