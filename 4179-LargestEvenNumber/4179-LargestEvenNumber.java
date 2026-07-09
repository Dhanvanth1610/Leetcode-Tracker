// Last updated: 7/9/2026, 2:13:49 PM
class Solution {
    public String largestEven(String s) {
        int j=s.length();
        
        for(int i=j-1;i>=0;i--){
            if(s.charAt(i)=='2'){
                return s.substring(0,i+1);

            
            }
        }
        return "";
    }
}