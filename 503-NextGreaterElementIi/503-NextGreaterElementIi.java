// Last updated: 7/9/2026, 2:16:08 PM
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> s=new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<n*2;i++){
            int x=nums[i%n];
            while(!s.empty() && x > nums[s.peek()])
                res[s.pop()] = x;
            s.push(i%n);    
        }
        return res;
    }
}