class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (!checkElements(board, i)) {
                return false;
            }
        }
        return true;
    }

    // returns true if row i has no conflicts (with itself, its columns, or its boxes)
    boolean checkElements(char[][] board, int i) {
        int n = board.length;

        for (int j = 0; j < n; j++) {
            if (board[i][j] == '.')
                continue;

            // row check: scan across columns of row i
            for (int l = 0; l < n; l++) {
                if (l != j && board[i][l] != '.' && board[i][j] == board[i][l]) {
                    return false;
                }
            }

            // column check: scan down rows of column j
            for (int k = 0; k < n; k++) {
                if (k != i && board[k][j] != '.' && board[i][j] == board[k][j]) {
                    return false;
                }
            }

            // box check
            int boxRowStart = (i / 3) * 3;
            int boxColStart = (j / 3) * 3;
            for (int m = boxRowStart; m < boxRowStart + 3; m++) {
                for (int o = boxColStart; o < boxColStart + 3; o++) {
                    if (!(m == i && o == j) && board[m][o] != '.' && board[m][o] == board[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
