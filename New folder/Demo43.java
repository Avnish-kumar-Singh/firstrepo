import java.util.*;

class Solution{
         public void quickSort(List<Integer> arr, int low, int high){
            if(low<high){
                int p=partition(arr, low, high);
                quickSort(arr, low, p-1);
                quickSort(arr, p+1, high);
            }
         }
            int partition(List<Integer> arr, int low, int high){
                int pivot=arr.get(high);
                int i=low-1;
                for(int j=low;j<=high-1;j++){
                    if(arr.get(j)<=pivot){
                        i+=1;
                        Collections.swap(arr, i, j);
                    }
                }
                Collections.swap(arr, i+1, high);
                return i+1;
            }
}
public class Demo43{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n=sc.nextInt();
        System.out.println("Enter the array elements:");
        List<Integer> arr= new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        Solution sol=new Solution();
        sol.quickSort(arr, 0, n-1);
        System.out.println("The sorted array is :"+arr);
        sc.close();
    }
}