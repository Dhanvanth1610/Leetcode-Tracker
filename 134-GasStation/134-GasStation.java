// Last updated: 7/11/2026, 1:35:03 PM
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ts =0;
        int rs=0;
        int ans=0;
        for(int i=0;i<gas.length;i++){
            ts+=gas[i] - cost[i];
            rs+=gas[i] - cost[i];
            if(rs<0){
                rs=0;
                ans =i+1;

            }
        }
        return ts >=0 ? ans:-1;
    }
}