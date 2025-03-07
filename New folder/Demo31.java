import java.util.Scanner;

class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;

        int maxx=nums[0];
        int steps=nums[0];
        int jump=1;

        for(int i=1;i<n;i++){
            if(i==n-1) return jump;

            maxx=Math.max(maxx, i+nums[i]);
            steps--;

            if(steps==0){
            if(i>=maxx) return -1;
             jump++;
            steps=maxx-i;
        }
      }
         return -1;
    }
   
}
public class Demo31{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Solution sol=new Solution();
        int res=sol.jump(nums);
        System.out.println("The result is:"+res);
        sc.close();

    }
}