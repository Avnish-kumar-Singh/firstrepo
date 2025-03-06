import java.util.Scanner;

class Solution {
    public String multiply(String num1, String num2) {
       if (num1.equals("0") || num2.equals("0")) return "0";

       
        int sign = 1;
        if (num1.charAt(0) == '-' && num2.charAt(0) != '-') sign = -1;
        if (num1.charAt(0) != '-' && num2.charAt(0) == '-') sign = -1;

       
        if (num1.charAt(0) == '-') num1 = num1.substring(1);
        if (num2.charAt(0) == '-') num2 = num2.substring(1);

        int n = num1.length(), m = num2.length();
        int[] res = new int[n + m];

       
        for (int i = n - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int mul = n1 * n2;
                int sum = res[i + j + 1] + mul;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

       
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0)) { 
                sb.append(num);
            }
        }

        
        if (sign == -1) sb.insert(0, '-');

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
public class Demo29{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first number:");
        String num1=sc.nextLine();
        System.out.println("Enter the second number:");
        String num2=sc.nextLine();
        Solution sol=new Solution();
        String res=sol.multiply(num1, num2);
        System.out.println("The product of two string is:"+res);
        sc.close();
    }
}