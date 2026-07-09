// Last updated: 7/9/2026, 2:14:40 PM
class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
         long res= 0;
        HashMap<Double,Integer> freq = new HashMap<>();
        for(int[] r : rectangles){
            double ratio = (double)r[0]/r[1];
            res = res + freq.getOrDefault(ratio,0);
            freq.put(ratio,freq.getOrDefault(ratio,0)+1);
        }
        return res; 
    }
}