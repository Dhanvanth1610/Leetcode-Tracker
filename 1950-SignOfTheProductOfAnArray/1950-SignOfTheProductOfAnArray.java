// Last updated: 7/9/2026, 2:14:47 PM
class Solution {
    public int arraySign(int[] nums) {
        int Count = 0;

        for (int n : nums) {
            if (n == 0) return 0;
            if (n < 0) Count++;
        }

        return (Count % 2 == 0) ? 1 : -1;
    }
}
