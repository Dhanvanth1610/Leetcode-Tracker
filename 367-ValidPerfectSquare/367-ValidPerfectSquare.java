// Last updated: 7/9/2026, 2:16:39 PM
class Solution {
    public boolean isPerfectSquare(int num) {
        long i=0;
        long j=num ;
        long mid;
        while(i<=j){
            mid=(i+j)/2;
            if(mid*mid==num){
                return true;
            }
            else if (mid *mid > num){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return false;


    }
}

           