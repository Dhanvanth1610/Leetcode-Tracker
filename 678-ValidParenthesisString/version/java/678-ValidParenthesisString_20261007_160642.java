// Last updated: 10/7/2026, 4:06:42 PM
1class Solution {
2    public boolean checkValidString(String s) {
3        Boolean[][]arr=new Boolean[s.length()][s.length()+1];
4        return helper(s,0,0,arr);
5    }
6    public static boolean helper(String s,int index,int sum,Boolean[][]dp){
7        if(sum<0)return false;
8        if(index>=s.length())return sum==0;
9        if(dp[index][sum]!=null)return dp[index][sum];
10        boolean result;
11        if(s.charAt(index)=='('){
12            result=helper(s,index+1,sum+1,dp);
13        }else if(s.charAt(index)==')'){
14            result=helper(s,index+1,sum-1,dp);
15        }else{
16            // three treatment (, ), ' '
17            result=helper(s,index+1,sum+1,dp)||
18                    helper(s,index+1,sum-1,dp)||
19                    helper(s,index+1,sum,dp);
20        }
21        dp[index][sum]=result;
22        return dp[index][sum];
23    }
24}