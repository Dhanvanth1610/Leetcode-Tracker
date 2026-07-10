// Last updated: 7/10/2026, 2:27:22 PM
1class Solution {
2
3    public List<List<Integer>> combine(int n, int k) {
4        List<List<Integer>> result = new ArrayList<>();
5        backtrack(1, n, k, new ArrayList<>(), result);
6        return result;
7    }
8
9    private void backtrack(int start, int n, int k,
10                           List<Integer> current,
11                           List<List<Integer>> result) {
12
13        if (current.size() == k) {
14            result.add(new ArrayList<>(current));
15            return;
16        }
17
18        for (int i = start; i <= n; i++) {
19            current.add(i);
20            backtrack(i + 1, n, k, current, result);
21            current.remove(current.size() - 1); // Backtrack
22        }
23    }
24}