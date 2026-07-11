// Last updated: 7/11/2026, 1:34:20 PM
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);  // drops the lowest set bit
            count++;
        }
        return count;
    }
}
