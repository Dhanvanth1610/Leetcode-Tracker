// Last updated: 7/12/2026, 6:33:01 PM
class Solution {
    public int maxSubArray(int[] nums) {
        int ms= nums[0];
        int cs= 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            cs+=nums[i];
            if(cs > ms)
                ms=cs;
            if(cs < 0)
                cs =0;
        }
        return ms;
    }
}

// class Solution {
//     public int maxSubArray(int[] nums) {
//         int ms= nums[0];
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//             int cs=nums[i];
//             for(int j=i+1;j<n;j++){
//                 cs+=nums[j];
//                 if(nums[j] > cs) cs=nums[j];
//                 if(cs>ms) ms=cs;

//             }
//         }
//         return ms;
//     }
// }
    
