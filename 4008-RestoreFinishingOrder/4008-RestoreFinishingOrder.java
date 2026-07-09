// Last updated: 7/9/2026, 2:13:58 PM
class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> set = new HashSet<>();
        for (int friend : friends) {
            set.add(friend);
        }

        int[] ans = new int[friends.length];
        int index = 0;

        for (int id : order) {
            if (set.contains(id)) {
                ans[index++] = id;
            }
        }

        return ans;
    }
}