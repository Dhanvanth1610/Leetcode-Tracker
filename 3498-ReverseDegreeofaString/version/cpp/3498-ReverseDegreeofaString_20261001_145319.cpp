// Last updated: 10/1/2026, 2:53:19 PM
1class Solution {
2public:
3    int reverseDegree(string& s) {
4        int sum=0, n=s.size();
5        for(int i=0; i<n; i++) sum+=(i+1)*('z'-s[i]+1);
6        return sum;
7    }
8};