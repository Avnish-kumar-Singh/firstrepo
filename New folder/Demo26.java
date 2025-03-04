import java.util.Scanner;

class Solution {
    boolean isSafe(char[][] board, int row, int col, char i) {
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == i) return false;
        }
        for (int k = 0; k < 9; k++) {
            if (board[k][col] == i) return false;
        }

        int srow = (row / 3) * 3;
        int scol = (col / 3) * 3;
        for (int l = srow; l < srow + 3; l++) {
            for (int m = scol; m < scol + 3; m++) {
                if (board[l][m] == i) return false;
            }
        }
        return true;
    }

    boolean helper(char[][] board, int row, int col) {
        if (row == 9) return true;

        int nextRow = row, nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (board[row][col] != '.') return helper(board, nextRow, nextCol);

        for (char i = '1'; i <= '9'; i++) {
            if (isSafe(board, row, col, i)) {
                board[row][col] = i;
                if (helper(board, nextRow, nextCol)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}

public class Demo26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];

        System.out.println("Enter the 9x9 Sudoku board:");
        for (int i = 0; i < 9; i++) {
            String row = sc.nextLine();
            if (row.length() != 9) {
                System.out.println("Invalid board");
                return;
            }
            for (int j = 0; j < 9; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        Solution sol = new Solution();
        sol.solveSudoku(board);

        System.out.println("\nThe solved Sudoku board:");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) System.out.println("+-------+-------+-------+"); 

            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0)
                 System.out.print("| "); 
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+"); 

        sc.close();
    }
}
