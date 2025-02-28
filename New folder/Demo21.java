// Evaluation of postfix expression..

import java.util.Scanner;

class Solution{
    public void nextPermutation(int[] nums){
        int n=nums.length;
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=n-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }
    private void swap(int[] nums, int i, int j){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private void reverse(int[] nums, int left, int right){
        while(left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
 }
 public class Demo21{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //int[] nums=new int[100];
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int[] nums=new int[n];

        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++){
             nums[i]=sc.nextInt();
        }
        Solution sol=new Solution();
        sol.nextPermutation(nums);

        System.out.println("The next permutation is:");
        for(int i=0;i<n;i++){
            System.out.println(nums[i]+" ");

        }
        System.out.println();
        sc.close();
    }
    
 }