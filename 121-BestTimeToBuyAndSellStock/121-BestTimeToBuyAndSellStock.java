// Last updated: 7/11/2026, 1:35:07 PM
class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int minbp=prices[0];
        for(int i=1;i<prices.length;i++){
            int sp = prices[i];
            if(sp>minbp){
                int pro = sp - minbp;
                if(pro > maxp) maxp = pro;
            }else{
                minbp = sp;
            }
        } return maxp;

        
    }
}
