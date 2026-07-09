// Last updated: 7/9/2026, 2:15:26 PM
class Solution {
    public int[] dailyTemperatures(int[] temp) { 
        int n= temp.length;
        Stack<Integer> s= new Stack();
        int [] ans = new int[n];
        for(int cday=0;cday<n;cday++){
            while(!s.empty() && temp[cday] > temp[s.peek()]){
                ans[s.peek()] = cday - s.peek();
                s.pop();
            }
            s.push(cday);
        }
        return ans;
    }
}