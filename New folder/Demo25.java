import java.util.*;

class Solution {
    private Set<List<Integer>> s = new HashSet<>(); 

    private void xyz(int[] candidates, int index, int target, List<List<Integer>> ans, List<Integer> combin) {
        if (index == candidates.length || target < 0) {
            return;
        }

        if (target == 0) {
            if (!s.contains(combin)) { 
                ans.add(new ArrayList<>(combin)); 
                s.add(new ArrayList<>(combin));
            }
            return;
        }

       
        combin.add(candidates[index]);
        xyz(candidates, index + 1, target - candidates[index], ans, combin);

        
        xyz(candidates, index, target - candidates[index], ans, combin);

       
        combin.remove(combin.size() - 1);
        xyz(candidates, index + 1, target, ans, combin);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        xyz(candidates, 0, target, ans, new ArrayList<>());
        return ans;
    }
}
public class Demo25{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n= sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array of elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the target value:");
        int target=sc.nextInt();
        Solution sol=new Solution();
        List<List<Integer>> res= sol.combinationSum(arr, target);
        System.out.println("The result is:"+res);
        sc.close();
    }
}