// Last updated: 9/8/2026, 9:13:18 PM
1class Solution {
2    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
3        // Sort robots and factories by position for optimal assignment
4        Collections.sort(robot);
5        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
6        
7        int m = robot.size();
8        int n = factory.length; 
9        
10        // dp[i][j] represents min total distance for robots[i:] using factories[j:]
11        long[][] dp = new long[m + 1][n + 1];
12        
13        // Set last column to MAX_VALUE as boundary condition
14        for (int i = 0; i < m; i++) {
15            dp[i][n] = Long.MAX_VALUE;
16        }
17        
18        // Process each factory from right to left
19        for (int j = n - 1; j >= 0; j--) {
20            // Track cumulative distance from current factory to robots
21            long prefix = 0;
22            // Use deque to maintain potential optimal assignments
23            Deque<Pair<Integer, Long>> qq = new ArrayDeque<>();
24            // Initialize with boundary condition
25            qq.offer(new Pair<>(m, 0L));
26            
27            // Process each robot from right to left
28            for (int i = m - 1; i >= 0; i--) {
29                // Add distance from current robot to current factory
30                prefix += Math.abs(robot.get(i) - factory[j][0]);
31                
32                // Remove assignments that exceed factory capacity
33                while (!qq.isEmpty() && qq.peekFirst().getKey() > i + factory[j][1]) {
34                    qq.pollFirst();
35                }
36                
37                // Remove suboptimal assignments
38                while (!qq.isEmpty() && qq.peekLast().getValue() >= dp[i][j + 1] - prefix) {
39                    qq.pollLast();
40                }
41                
42                // Add current state to deque
43                qq.offerLast(new Pair<>(i, dp[i][j + 1] - prefix));
44                // Update dp with optimal assignment
45                dp[i][j] = qq.peekFirst().getValue() + prefix;
46            }
47        }
48        
49        // Return minimum total distance for all robots
50        return dp[0][0];
51    }
52    
53    // Helper class to store key-value pairs
54    private static class Pair<K, V> {
55        private K key;
56        private V value;
57        
58        public Pair(K key, V value) {
59            this.key = key;
60            this.value = value;
61        }
62        
63        public K getKey() {
64            return key;
65        }
66        
67        public V getValue() {
68            return value;
69        }
70    }
71}