
import java.util.*;
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); 
        boolean[] used = new boolean[nums.length]; 
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> tempList, boolean[] used, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); 
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            
            if (used[i]) continue;

           
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            tempList.add(nums[i]);

            backtrack(nums, tempList, used, result);

            // Backtrack
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
public class Demo32{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.err.println("Enter the value of n");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Solution sol=new Solution();
        List<List<Integer>>ans=sol.permuteUnique(nums);
        System.err.println("The result is");
        for(List<Integer>perm:ans){
            System.out.println(perm);
        }
        sc.close();

    }
}