import java.util.Scanner;

class Solution{
    public int trapWater(int[] arr){
        int n=arr.length;
        int[] next=new int[n];
        int prev_max=0, result=0;
        next[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            next[i]=Math.max(next[i+1], arr[i]);
        }
        for(int i=0;i<n;i++){
            prev_max=Math.max(prev_max, arr[i]);
            result+=Math.min(prev_max, next[i])-arr[i];
        }
        return result;
    }
    // return result;
}

public class Demo28{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array of elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Solution sol=new Solution();
        int res=sol.trapWater(arr);
        System.out.println("Maxmium stored water is :"+res);
        sc.close();
    }
}