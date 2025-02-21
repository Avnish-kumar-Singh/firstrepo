import java.util.Scanner;

class Solution {
    public int removeDuplicates(int[] nums) {
         if (nums.length == 0) return 0; 
        int index = 0; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i]; 
            }
        }

        return index + 1; 
    
    }
}
public class Demo15{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Solution s = new Solution();
        int result = s.removeDuplicates(nums);
        System.out.println("The length of array after removing duplicates elements is:"+result);
        sc.close();
    }

}