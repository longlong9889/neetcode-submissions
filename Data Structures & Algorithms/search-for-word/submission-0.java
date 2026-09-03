class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int index, int i, int j) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char original = board[i][j];
        board[i][j] = '#';
        boolean found = helper(board, word, index + 1, i + 1, j)
        || helper(board, word, index + 1, i - 1, j)
        || helper(board, word, index + 1, i, j + 1)
        || helper(board, word, index + 1, i, j - 1);
        board[i][j] = original;
        return found;
    }
}
