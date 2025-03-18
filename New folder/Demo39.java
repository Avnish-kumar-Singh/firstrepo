import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> ans = new ArrayList<>();
         if(matrix==null || matrix.length==0) return ans;

        int n=matrix.length;
        int m=matrix[0].length;
        int l=0, r=m-1;
        int t=0, b=n-1;
       // List<Integer> ans;

        while (t <= b && l <= r) {
            
        for (int i = l; i <= r; i++) {
                ans.add(matrix[t][i]);
            }
            t++;
    

    for (int i = t; i <= b; i++) {
                ans.add(matrix[i][r]);
            }
            r--;

            
            if (t <= b) {
                for (int i = r; i >= l; i--) {
                    ans.add(matrix[b][i]);
                }
                b--;
            }

           
            if (l <= r) {
                for (int i = b; i >= t; i--) {
                    ans.add(matrix[i][l]);
                }
                l++;
            }
           
        }
        return ans;
}
}
public class Demo39{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the matrix size:");
        int n=sc.nextInt();
        int m=sc.nextInt();
        System.out.println("Enter the matrix elements:");
        int[][] matrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        Solution sol=new Solution();
        System.out.println("The Spiral order is:"+sol.spiralOrder(matrix));
        sc.close();

    }
}