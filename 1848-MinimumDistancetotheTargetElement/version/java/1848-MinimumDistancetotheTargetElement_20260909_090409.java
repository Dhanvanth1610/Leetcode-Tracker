// Last updated: 9/9/2026, 9:04:09 AM
1class Solution {
2    public List<Integer> solveQueries(int[] nums, int[] queries) {
3        int n = nums.length;
4 
5        Map<Integer, List<Integer>> indices = new HashMap<>();  // num -> sorted indices
6        int[] idxs = new int[n];  // i -> index in indices[nums[i]]
7        for (int i = 0; i < n; i++) {
8            idxs[i] = indices.computeIfAbsent(nums[i], x -> new ArrayList<>()).size();
9            indices.get(nums[i]).add(i);
10        }
11 
12        List<Integer> result = new ArrayList<>();
13        for (int q : queries) {
14            List<Integer> qind = indices.get(nums[q]);
15            int sz = qind.size();
16            if (sz == 1) {
17                result.add(-1);
18            } else {
19                int j = idxs[q];  // Get index in qind with O(1)
20                int prev = qind.get((j - 1 + sz) % sz);
21                int nextt = qind.get((j + 1) % sz);
22                result.add(Math.min(
23                    (nextt + n - qind.get(j)) % n,
24                    (qind.get(j) - prev + n) % n
25                ));
26            }
27        }
28 
29        return result;
30    }
31}