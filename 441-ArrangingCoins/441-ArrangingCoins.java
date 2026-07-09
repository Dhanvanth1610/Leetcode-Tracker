// Last updated: 7/9/2026, 2:16:20 PM
class Solution {
    public int arrangeCoins(int n) {
        int row=1;
        while (n>=row){
            n-=row;
            row++;
        }
        return row-1; 
    }
}