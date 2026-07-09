// Last updated: 7/9/2026, 2:14:33 PM
class Solution {
    public int smallestEvenMultiple(int n) {
        return (n % 2 == 0) ? n : 2 * n;
    }
}