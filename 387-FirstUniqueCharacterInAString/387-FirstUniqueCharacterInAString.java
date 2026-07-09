// Last updated: 7/9/2026, 2:16:38 PM
class Solution {
    public int firstUniqChar(String s) {
        for(int i=0;i<s.length();i++){
            boolean ans =true;
            for(int j=0;j<s.length();j++){
                if(i!=j&&s.charAt(i)==s.charAt(j)){
                    ans=false;
                    break;
                }
            }
            if(ans==true)return i;
        }
        return -1;
    }
}