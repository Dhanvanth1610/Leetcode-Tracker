// Last updated: 7/9/2026, 2:14:08 PM
class Solution {
    public int minimumOperations(int[] nums) {
        int n=0;
        for(int num:nums){
            int temp=num%3;
            if (temp==1){
                n+=1;
            }else if(temp==2){
                n+=1;
            }
        }
        return n;  
    }
}