import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
       int n=intervals.length;
       if(n==0)  return new int[0][0];
       Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
       List<int[]>xyz=new ArrayList<>();
       int[] curr=intervals[0];
       xyz.add(curr);

       for(int i=1;i<n;i++){
        int[] next=intervals[i];
        if(next[0]<=curr[1]){
            curr[1]=Math.max(curr[1], next[1]);
        }else{
            curr=next;
            xyz.add(curr);
        }
       }
       return xyz.toArray(new int[xyz.size()][]);
    }
}
public class Demo41{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of intervals:");
        int n=sc.nextInt();
        int[][] intervals=new int[n][2];
        System.out.println("Enter the intervals:");
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                intervals[i][j]=sc.nextInt();
            }
        }
        Solution sol=new Solution();
        int[][] merged = sol.merge(intervals);
        System.out.println("The merged intervals are:");
        for (int[] interval : merged) {
        System.out.println(Arrays.toString(interval));
        }
        sc.close();
    }
}