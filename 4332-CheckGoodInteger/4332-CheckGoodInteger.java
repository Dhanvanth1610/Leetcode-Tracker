// Last updated: 7/9/2026, 2:13:44 PM
class Solution {
    public boolean checkGoodInteger(int n) {
        int dsum = 0;
        int ssum =0;
        while (n>0){
            int d = n%10;
            dsum += d;
            ssum += d*d;
            n/=10;
            
        }
        return (ssum  - dsum ) >= 50;
        
    }
}