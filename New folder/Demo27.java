import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        bubblesort(candidates);
        List<List<Integer>>result=new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    void bubblesort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    void backtrack(int[] candidates, int target, int start, List<Integer>tempList, List<List<Integer>>result){
        if(target==0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=start; i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1])
            continue;
            if(candidates[i]>target)
            break;
            tempList.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i+1, tempList, result);
            tempList.remove(tempList.size()-1);
        }
    }
}
public class Demo27{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array of elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the target value:");
        int target=sc.nextInt();
        Solution sol=new Solution();
        List<List<Integer>> res=sol.combinationSum2(arr, target);
        System.out.println("The result is :"+res);
        sc.close();
    }
}