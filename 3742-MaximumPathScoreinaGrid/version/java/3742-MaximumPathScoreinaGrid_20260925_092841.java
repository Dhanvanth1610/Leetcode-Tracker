// Last updated: 9/25/2026, 9:28:41 AM
1class Solution {
2    public boolean canReach(String s, int minJump, int maxJump) {
3        Queue<Integer>queue=new LinkedList<>();
4        int len=s.length()-1;
5        if(s.charAt(len)!='0')return false;
6        queue.offer(0);
7        int end=0;
8        while(!queue.isEmpty()){
9            int cur=queue.poll();
10            if(cur==len)return true;
11            int tempMin=Math.max(minJump+cur,end+1);
12            int tempMax=Math.min(maxJump+cur,len);
13            while(tempMin<=tempMax){
14                if(tempMin>len)break;
15                if(s.charAt(tempMin)=='0')queue.offer(tempMin);
16                tempMin++;
17            }
18            end=tempMax;
19        }
20        return false;
21    }
22}