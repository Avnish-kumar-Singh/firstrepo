import java.util.Scanner;

class Solution{
    public boolean jumpGame(int[] nums){
        int n=nums.length;
        if(n==1) return true;
        if(nums[0]==0) return false;
        int maxx=nums[0];
        int pos=nums[0];

        for(int i=1;i<n;i++){
            if(i==n-1) return true;
            maxx=Math.max(maxx, i+nums[i]);
            pos--;

            if(pos==0){
                if(i>=maxx) return false;
                pos=maxx-i; 
            }
        }
        return false;
    }
}
public class Demo40{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Solution sol=new Solution();
        System.out.println("The result is:"+sol.jumpGame(nums));
        sc.close();
    }
}