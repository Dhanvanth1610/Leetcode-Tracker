// Last updated: 7/9/2026, 2:16:23 PM
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
        int end=intervals[0][1];
        int c=0;
        for(int i=1;i<n;i++){
            if(intervals[i][0]<end){
                c=c+1;
            }
            else{
                end=intervals[i][1];
            }

        }
        return c;
        
    }
}