// Last updated: 7/12/2026, 6:34:42 PM
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int x=target - nums[i];
            if(map.containsKey(x)){
                res[0] = i;
                res[1] = map.get(x);
                return res;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
}