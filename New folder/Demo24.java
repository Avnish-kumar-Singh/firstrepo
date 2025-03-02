
import java.util.Scanner;
//import java.util.stream.Gatherer;

class Solution{
    public String CountAndSay(int n){
        if(n==1) return "1";
        if(n==2) return "11";

        String s="11";
        for(int i=3;i<=n;i++){
            String temp="";
          //  s+="s";
            int count=1;

            for(int j=1;j<s.length();j++){
                if(s.charAt(j-1)!=s.charAt(j)){
                    temp+=Integer.toString(count);
                    temp+=s.charAt(j-1);
                    count=1;
                }else{
                    count++;
                }
            }
            temp += Integer.toString(count); // ✅ Append last counted digit
            temp += s.charAt(s.length() - 1);
            s=temp;
        }
        return s;
    }
}
public class Demo24{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the vlaue of n:");
        int n=sc.nextInt();
        // System.out.println("Enter the array of Elements:");
        // for(int i=0;i<n;i++){
            // int ele=sc.nextInt();
        // }
        Solution sol=new Solution();
        String res=sol.CountAndSay(n);
        System.out.println("The result is:"+res);
        sc.close();

    }
}