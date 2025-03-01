import java.util.Scanner;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] grids = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '0';
                    if (n < 1 || n > 9) return false;

                    int k = (i / 3) * 3 + (j / 3); 

                    if (rows[i][n - 1] > 0 || cols[j][n - 1] > 0 || grids[k][n - 1] > 0)
                        return false;

                    rows[i][n - 1]++;
                    cols[j][n - 1]++;
                    grids[k][n - 1]++;
                }
            }
        }
        return true;
    }
}

public class Demo23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];

        System.out.println("Enter the 9x9 Sudoku board (each row should be 9 characters, use '.' for empty cells):");
        
        for (int i = 0; i < 9; i++) {
            String row = sc.nextLine();  
            if (row.length() != 9) {  
                System.out.println("Invalid input! .");
                return;
            }
            for (int j = 0; j < 9; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        Solution sol = new Solution();
        boolean res = sol.isValidSudoku(board);
        System.out.println("The Sudoku board is valid: " + res);
        
        sc.close();
    }
}
