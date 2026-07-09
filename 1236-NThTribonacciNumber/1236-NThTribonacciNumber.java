// Last updated: 7/9/2026, 2:15:09 PM
class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        int prev1=0,prev2=1,prev3=1,next=0;
        for(int i=1;i<=n-2;i++){
            next=prev1+prev2+prev3;
            prev1=prev2;
            prev2=prev3;
            prev3=next;
        }
        return next;
    }
}