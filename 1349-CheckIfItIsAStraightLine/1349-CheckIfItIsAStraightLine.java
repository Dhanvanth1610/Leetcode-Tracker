// Last updated: 7/9/2026, 2:15:02 PM
class Solution {
    public boolean checkStraightLine(int[][] co) {
        int x0 = co[0][0], y0 = co[0][1];
        int x1 = co[1][0], y1 = co[1][1];

        for (int i = 2; i < co.length; i++) {
            int x = co[i][0], y = co[i][1];
            if ((y1 - y0) * (x - x0) != (y - y0) * (x1 - x0)) {
                return false;
            }
        }
        return true;
    }
}
