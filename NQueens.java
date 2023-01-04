public class NQueens {
    static int count = 0;

    public static void nQueensAllWays(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueensAllWays(board, row + 1);
                board[row][j] = '.';
            }

            // board[row][j] = 'Q';
            // nQueensAllWays(board, row + 1);
            // board[row][j] = '.';
        }
    }

    public static void nQueensCountWays(char[][] board, int row) {
        if (row == board.length) {
            // printBoard(board);

            count++;

            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueensCountWays(board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // Check vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check diag left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Chect diag right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void printBoard(char board[][]) {
        System.out.println("---------- Chess board ----------");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.err.print("\n");
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // nQueensAllWays(board, 0);
        nQueensCountWays(board, 0);

        System.out.println("Number of ways: " + count);
    }
}
