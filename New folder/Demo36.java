
import java.util.Scanner;

class Solution {
    public double Poww(double x, int n) {
        if(n==0) return 1;
        long n1=n;
        if(n1<0){
            x=1/x;
            n1=-n1;
        }
        double ans=1;
        while(n1>0){
            if(n1%2!=0){
                ans*=x;
            }
            x*=x;
            n1/=2;
        }
        return ans;
    }
}
public class Demo36{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of x:");
        double x=sc.nextDouble();
        System.out.println("Enter the value of n:");
        int n=sc.nextInt();
        Solution sol=new Solution();
        double ans=sol.Poww(x,n);
        System.out.println("The result is:"+ans);
        sc.close();
    }
}