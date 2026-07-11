// Last updated: 7/11/2026, 1:34:39 PM
class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb=new StringBuffer();
        while(n !=0){
            int d=--n%26;
            sb.append((char)(d+65));
            n/=26;
        }
        return sb.reverse().toString();
    }
}