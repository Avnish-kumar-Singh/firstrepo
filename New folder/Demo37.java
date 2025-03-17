import java.util.*;

class Solution {

    boolean isSafe(List<String> board, int row, int col, int n) {
        
         for (int i = 0; i < n; i++) {
             if (board.get(row).charAt(i) == 'Q') return false;
         }
 
         
         for (int i = 0; i < n; i++) {
             if (board.get(i).charAt(col) == 'Q') return false;
         }
 
        
         for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
             if (board.get(i).charAt(j) == 'Q') return false;
         }
 
         
         for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
             if (board.get(i).charAt(j) == 'Q') return false;
         }
 
         return true;
     }
 
     void abc(List<String> board, int row, int n, List<List<String>> result) {
         if (row == n) {
             result.add(new ArrayList<>(board)); 
             return;
         }
 
         for (int i = 0; i < n; i++) {
             if (isSafe(board, row, i, n)) {
                
                 board.set(row, board.get(row).substring(0, i) + 'Q' + board.get(row).substring(i + 1));
                 
                
                 abc(board, row + 1, n, result);
                 
                
                 board.set(row, board.get(row).substring(0, i) + '.' + board.get(row).substring(i + 1));
             }
         }
     }
     public List<List<String>> solveNQueens(int n) {
         List<String> board = new ArrayList<>(Collections.nCopies(n, ".".repeat(n)));
         List<List<String>> result = new ArrayList<>();
         abc(board, 0, n, result);
         return result;
     }
 
    //  public static void main(String[] args) {
        //  Solution sol = new Solution();
        //  System.out.println(sol.solveNQueens(4));
    //  }
 }
 public class Demo37{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
       // int n=sc.nextInt();
        System.out.println("Enter the value of n");
        int n=sc.nextInt();
        Solution sol=new Solution();
        System.out.println("The result is:"+sol.solveNQueens(n));
        System.out.println("\n");
        sc.close();

    }
 }