// Last updated: 7/9/2026, 2:16:12 PM
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        Stack<Integer> s= new Stack<>();
        int[] res=new int[nums1.length];
        Arrays.fill(res,-1);
        for(int x: nums2){
            while(!s.empty() && x> s.peek())
                freq.put(s.pop(),x);
            s.push(x);
        }
        for(int i=0;i<nums1.length;i++){
            if(freq.containsKey(nums1[i])){
                res[i]=freq.get(nums1[i]);
            }
        }
        return res;



    }
}