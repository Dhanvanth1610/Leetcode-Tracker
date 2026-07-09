// Last updated: 7/9/2026, 2:15:15 PM
class Solution {
    public int numRookCaptures(char[][] board) {
        int rookRow = 0, rookCol = 0;

        // find the rook
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (board[i][j] == 'R') {
                    rookRow = i;
                    rookCol = j;
                }

        int count = 0;

        // check UP
        for (int r = rookRow - 1; r >= 0; r--) {
            if (board[r][rookCol] == 'B') break;
            if (board[r][rookCol] == 'p') { count++; break; }
        }

        // check DOWN
        for (int r = rookRow + 1; r < 8; r++) {
            if (board[r][rookCol] == 'B') break;
            if (board[r][rookCol] == 'p') { count++; break; }
        }

        // check LEFT
        for (int c = rookCol - 1; c >= 0; c--) {
            if (board[rookRow][c] == 'B') break;
            if (board[rookRow][c] == 'p') { count++; break; }
        }

        // check RIGHT
        for (int c = rookCol + 1; c < 8; c++) {
            if (board[rookRow][c] == 'B') break;
            if (board[rookRow][c] == 'p') { count++; break; }
        }

        return count;
    }
}
