import java.util.Scanner;

class Solution {

    int xyz(int[] nums, int target){
       int n=nums.length;
       int low=0, high=n-1, currIndex=-1;
       while(low<=high){
           int mid=low+(high-low)/2;
           if(nums[mid]==target){
               currIndex=mid;
               high=mid-1;
           }else if(nums[mid]<target){
               low=mid+1;
           }else{
               high=mid-1;
           }
       }
       return currIndex;
    }

    int abc(int[] nums, int target){
       int n=nums.length;
       int low=0, high=n-1, lastIndex=-1;
       while(low<=high){
           int mid=low+(high-low)/2;
           if(nums[mid]==target){
               lastIndex=mid;
               low=mid+1;
           }else if(nums[mid]<target){
               low=mid+1;
           }else{
               high=mid-1;
           }
       }
       return lastIndex;
    }

   public int[] searchRange(int[] nums, int target) {
      return new int[]{xyz(nums, target), abc(nums, target)};

   }
}

public class Demo22{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("Enter the target elements:");
        int target=sc.nextInt();
        Solution sol=new Solution();
        int[] res=sol.searchRange(nums, target);
        System.out.println("The range is:");
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]+" ");
        }
        System.out.println();
        sc.close();
    }
}