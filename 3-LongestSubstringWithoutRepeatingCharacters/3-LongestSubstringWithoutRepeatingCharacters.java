// Last updated: 7/12/2026, 6:34:39 PM
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        int ans = 0;
        for (int i=0;i<n;i++){
            int freq[] = new int[256];
            for(int j=i;j<n;j++){
                if(freq[s.charAt(j)] >0){
                    break;
                }
                else{
                    freq[s.charAt(j)]++;
                    ans=Math.max(ans,j-i+1);
                }
                
            }
        }
        return ans;
    }
}