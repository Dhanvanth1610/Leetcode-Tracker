// Last updated: 10/6/2026, 8:57:49 AM
1class Solution {
2    public int minAddToMakeValid(String s) {
3        int ans=0;
4        Stack<Character> st=new Stack<>();
5        for(int i=0;i<s.length();i++){
6            char ch=s.charAt(i);
7            if(ch=='(') st.push(ch);
8            else{
9                if(st.isEmpty()) ans++;
10                else st.pop();
11            }
12        }
13        ans+=st.size();
14        return ans;
15    }
16}