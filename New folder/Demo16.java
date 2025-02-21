import java.util.Scanner;

class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int index=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=val){
                nums[index]=nums[i];
                index++;
            }
        }
        return index;
    }
}

public class Demo16{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers of elements in the array:");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the element of the array:");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("Enter the value of element to be removed(val):");
        int val=sc.nextInt();
        Solution s=new Solution();
        int result=s.removeElement(nums, val);
        System.out.println("The length of array after removing the element is:"+result);
        sc.close();
    }
}