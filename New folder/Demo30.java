import java.util.*;

class Solution {
    int[][] dp; 
    
    int abc(int i, int j, String s, String p) {
        if (i < 0 && j < 0) return 1; 
        if (i < 0 && j >= 0) return 0; 
        if (j < 0 && i >= 0) { 
            for (int a = 0; a <= i; a++) {
                if (p.charAt(a) != '*') return 0;
            }
            return 1;
        }

       
        if (dp[i][j] != -1) return dp[i][j];

        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
            return dp[i][j] = abc(i - 1, j - 1, s, p);
        }
        if (p.charAt(i) == '*') {
            return dp[i][j] = (abc(i - 1, j, s, p) == 1 || abc(i, j - 1, s, p) == 1) ? 1 : 0;
        }

        return dp[i][j] = 0;
    }

    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        dp = new int[n][m]; 
        for (int[] row : dp) Arrays.fill(row, -1);
        return abc(n - 1, m - 1, s, p) == 1;
    }
}
public class Demo30{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the first strings:");
        String s=sc.nextLine();
        System.out.println("Enter the second elements:");
        String p=sc.nextLine();
        Solution sol=new Solution();
        boolean res=sol.isMatch(s,p);
        System.out.println("The result is:"+res);
        sc.close();
    }
}