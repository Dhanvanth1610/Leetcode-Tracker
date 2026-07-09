// Last updated: 7/9/2026, 2:16:17 PM
class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            count += z & 1;  // add 1 if last bit is 1
            z >>= 1;         // shift right
        }
        return count;
    }
}
