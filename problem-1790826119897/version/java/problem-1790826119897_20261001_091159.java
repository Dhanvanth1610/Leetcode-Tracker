// Last updated: 10/1/2026, 9:11:59 AM
1class Solution {
2    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
3        Arrays.sort(asteroids);
4        long curMass=mass;
5        for(int val:asteroids){
6            if(val>curMass)return false;
7            curMass+=val;
8        }
9        return true;
10    }
11}