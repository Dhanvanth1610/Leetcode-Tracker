// Last updated: 10/17/2026, 10:44:56 PM
1class Solution {
2    class State {
3        int num;
4        int digitSum;
5        int originalIndex;
6        public State(int num, int originalIndex) {
7            this.num = num;
8            this.originalIndex = originalIndex;
9            int c = num;
10            while(c > 0) {
11                this.digitSum += c % 10;
12                c /= 10;
13            }
14        }
15        @Override
16        public String toString() {
17            return "State{num="+num+",digitSum="+digitSum+",originalIndex="+originalIndex+"}";
18        }
19    }
20    public int minSwaps(int[] nums) {
21        State[] states = new State[nums.length];
22        for(int i = 0; i < nums.length; i++) {
23            states[i] = new State(nums[i],i);
24        }
25        // Swapping 2 nums that just need to switch positions -> 1 turn
26        // Placing 1 num correctly otherwise -> 1 turn
27        Arrays.sort(states, (a,b) -> {
28            if(a.digitSum != b.digitSum) return a.digitSum - b.digitSum;
29            return a.num - b.num;
30        });
31        int r = 0;
32        for(int i = 0; i < states.length; i++) {
33            if(states[i].originalIndex == i) continue;
34            boolean redo = false;
35            if(states[states[i].originalIndex].originalIndex != states[i].originalIndex) {
36                redo = true;
37            }
38            int temp = states[i].originalIndex;
39            states[i].originalIndex = states[states[i].originalIndex].originalIndex;
40            states[temp].originalIndex = temp;
41            r++;
42            if(redo) i--;
43        }
44        return r;
45    }
46    //    
47    //    State{num=16,digitSum=7,originalIndex=3}
48    //    State{num=34,digitSum=7,originalIndex=2}
49    //    State{num=18,digitSum=9,originalIndex=0}
50    //    State{num=43,digitSum=7,originalIndex=1}
51    // 
52}