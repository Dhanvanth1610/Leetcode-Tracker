// Last updated: 9/14/2026, 7:54:55 PM
1class Solution {
2    public int maxDistance(int[] nums1, int[] nums2) {
3        int n = nums1.length;
4        int m = nums2.length;
5        int dis = 0;
6        int j=0;
7        for(int i=0; i<n; i++){
8            int val = nums1[i];
9            if(j<i)j=i+1;
10            while(j<m && nums2[j]>=nums1[i]){
11                j++;
12            }
13            dis = Math.max(dis,j-i-1);
14        }
15        return dis;
16    }
17}