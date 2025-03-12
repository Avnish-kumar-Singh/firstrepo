
import java.util.Scanner;
class Solution{
    public void rotate(int[][] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=nums[i][j];
                nums[i][j]=nums[j][i];
                nums[j][i]=temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for(int j=0;j<n/2;j++){
                int temp=nums[i][j];
                nums[i][j]=nums[i][n-j-1];
                nums[i][n-j-1]=temp;
            }
        }
    }
}
public class Demo33{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n=sc.nextInt();
        int[][] nums=new int[n][n];
        System.out.println("Enter the elelemnts of the matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nums[i][j]=sc.nextInt();
            }
        }
        Solution sol=new Solution();
        sol.rotate(nums);
        System.out.println("The rotated matrix is:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println(""+nums[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}