// Last updated: 7/9/2026, 2:14:39 PM
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;

        for (String op : operations) {
            if (op.charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }

        return x;
    }
}