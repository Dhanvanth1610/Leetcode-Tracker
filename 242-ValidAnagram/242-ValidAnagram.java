// Last updated: 7/9/2026, 2:16:56 PM
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> hm =new HashMap();
        for(char ch :s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+ 1);
        }for(char ch :t.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0) -1);
        }
        for(int x : hm.values()){
            if(x!=0) return false;
        }
        return true;
    }
}