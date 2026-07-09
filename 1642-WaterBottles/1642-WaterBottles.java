// Last updated: 7/9/2026, 2:14:51 PM
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrank = 0;
        int empty = 0;

        int full = numBottles;

        while (full > 0) {
            totalDrank += full;      
            empty += full;           
            full = empty / numExchange; 
            empty = empty % numExchange; 
        }

        return totalDrank;
        // int val = 0;
        // while(numBottles>numExchange){
        //     val += numBottles / numExchange;
        //     numBottles = numBottles/numExchange;
        // }
        // return val+1;
    }
}
