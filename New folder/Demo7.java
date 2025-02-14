import java.util.Scanner;

class Solution {

        public void bubblesort(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    } 
    public int threeSumClosest(int[] nums, int target) {
        
        int n=nums.length;
        if(n<3){
            return 0;
        }

        bubblesort(nums);
        int ans=0;
        int closest=Integer.MAX_VALUE;
        for(int i=0;i<=n-3;i++){
            int j=i+1;
            int l=n-1;

            while(j<l){
                int tempsum=nums[i]+nums[j]+nums[l];

                if(Math.abs(target-tempsum)<closest){
                    closest=Math.abs(target-tempsum);
                    ans=tempsum;
                }
                else if(tempsum<target){
                    j++;
                }
                else{
                    l--;
                }
            }
        }
        return ans;
    }
}

public class Demo7 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in array:");
        int n=sc.nextInt();

        int[] nums=new int[n];

        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        Solution s=new Solution();
        System.out.println("Enter the target sum");
        int target=sc.nextInt();

        System.out.println("The closest sum is:"+s.threeSumClosest(nums, target));
        sc.close();
    }
}