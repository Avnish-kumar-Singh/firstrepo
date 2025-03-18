import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans=new ArrayList<>();
        int i=0;
        int n=intervals.length;
      // if(n==0)  return new int[0][0];

      while(i<n && intervals[i][1]< newInterval[0]){
        ans.add(intervals[i]);
        i++;
      }

      while(i<n && intervals[i][0]<=newInterval[1]){
        newInterval[0]=Math.min(newInterval[0], intervals[i][0]);
        newInterval[1]=Math.max(newInterval[1], intervals[i][1]);
        i++;
      }
      ans.add(newInterval);

      while(i<n){
        ans.add(intervals[i]);
        i++;
      }



    //   int[][] updateIntervals= new int[n+1][2];
    //   for(int i=0;i<n;i++){
    //     updateIntervals[i]=intervals[i];
    //   }
    //   updateIntervals[n]=newInterval;
    //    Arrays.sort(updateIntervals, Comparator.comparingInt(a -> a[0]));

    //    List<int[]>xyz=new ArrayList<>();
    //    int[] curr=intervals[0];
    //    xyz.add(curr);

    //    for(int i=1;i<n;i++){
    //     int[] next=updateIntervals[i];
    //     if(next[0]<=curr[1]){
    //         curr[1]=Math.max(curr[1], next[1]);
    //     }else{
    //         curr=next;
    //         xyz.add(curr);
    //     }
    //    }
       return ans.toArray(new int[ans.size()][]);
    }
}
public class Demo42{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of intervals:");
        int n=sc.nextInt();
        System.out.println("Enter the intervals elements:");
        int[][] intervals=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                intervals[i][j]=sc.nextInt();
                
            }
        }
        System.out.println("Enter the new Intervals:");
        int[] newInterval=new int[2];
        for(int i=0;i<2;i++){
            newInterval[i]=sc.nextInt();
        }
        Solution sol=new Solution();
        int[][] merged=sol.insert(intervals, newInterval);
        System.out.println("The merged Intervals are:");
        for(int[] interval:merged){
            System.out.println("["+interval[0]+","+interval[1]+"]");

        }
        sc.close();
    }
}