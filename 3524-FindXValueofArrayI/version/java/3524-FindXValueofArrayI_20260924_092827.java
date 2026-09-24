// Last updated: 9/24/2026, 9:28:27 AM
1class Solution {
2    public int minJumps(int[] arr) {
3        int n = arr.length;
4        
5        if(n == 1) return 0;
6        Map<Integer, List<Integer>> map = new HashMap<>();
7        int step = 0;
8        
9        // fill the map
10        for(int i = 0; i < n; i++){
11            map.computeIfAbsent(arr[i], v -> new ArrayList()).add(i);
12        }
13        Queue<Integer> q = new LinkedList<>();
14        q.offer(0);
15        
16        while(!q.isEmpty()){
17            step++;
18            int size = q.size();
19            for(int i = 0; i < size; i++){
20                int j = q.poll();
21            
22                if(j - 1 >= 0 && map.containsKey(arr[j - 1])){
23                    q.offer(j - 1);
24                }
25
26                if(j + 1 < n && map.containsKey(arr[j + 1])){
27                    if(j + 1 == n - 1) return step;
28                    q.offer(j + 1);
29                }
30
31                if(map.containsKey(arr[j])){
32                    for(int k : map.get(arr[j])){
33                        if(k != j){
34                            if(k == n - 1) return step;
35                            q.offer(k);
36                        }
37                    }
38                }
39                map.remove(arr[j]);
40            }
41        }
42        
43        return step;
44    }
45}