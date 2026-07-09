// Last updated: 7/9/2026, 2:13:55 PM
class Solution {
    public long minCost(String s, int[] cost) {
        long total = 0;
        for ( int i=0;i < cost.length;i++){
            total = total+ cost[i];
        }
        long min = Long. MAX_VALUE;
        for( char ch='a';ch<='z'; ch ++){
            long keep = 0;
            for ( int i = 0;i< s. length(); i ++){
                if( s.charAt(i)==ch){
                    keep = keep + cost[i];
                    
                }
            }
            long remove = total - keep;
            if ( remove < min){
                min = remove;
            }
        }
        return min;
    }
}